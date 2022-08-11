/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 14:53
 * @Version 1.0
 */
package com.example.java_gobang.api;

import com.example.java_gobang.game.Match;
import com.example.java_gobang.game.MatchRequest;
import com.example.java_gobang.game.MatchResponse;
import com.example.java_gobang.game.OnlineUserManager;
import com.example.java_gobang.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
//对于匹配的消息处理类
public class MatchAPI extends TextWebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OnlineUserManager onlineUserManager;

    @Autowired
    private Match match;

    @Override
    //处理用户连接
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //session.getAttributes()获取到的是一个map，里面存放了了HttpSession中的getAttribute里的所有对象
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            //玩家还未登陆就进入游戏大厅了
            MatchResponse response = new MatchResponse();
            response.setOk(false);
            response.setReason("[afterConnectionEstablished]玩家尚未登录!");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
            return;
        }
        //检查玩家的上线状态（是否多开）
        //在给玩家设置上线状态时，需要先判断之前玩家是否已经登录过了
        if (onlineUserManager.getGameHallSession(user.getUserId()) != null
        || onlineUserManager.getGameRoomSession(user.getUserId()) != null){
            MatchResponse response = new MatchResponse();
            response.setOk(true);
            response.setReason("当前游戏禁止多开");
            response.setMessage("repeatConnection");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
            return;
        }
        //当玩家获取到身份信息后，就可以给玩家设置上线状态了
        onlineUserManager.enterGameHall(user.getUserId(),session);
        System.out.println("当前玩家" + user.getUsername() + "进入游戏大厅");
    }

    @Override
    //处理开始/取消匹配
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            System.out.println("[handleTextMessage]玩家尚未登录");
            return;
        }
        System.out.println("开始匹配" + user.getUserId() + "message" + message.toString());
        //将解析得到的JSON请求数据转换为一个MatchRequest对象
        MatchRequest request = objectMapper.readValue(message.getPayload(),MatchRequest.class);
        MatchResponse response = new MatchResponse();
        if(request.getMessage().equals("startMatch")){
            //加入匹配器中
            //TODO
            match.add(user);
            response.setMessage("startMatch");
        }else if(request.getMessage().equals("stopMatch")){
            //从匹配器中移除
            //TODO
            match.remove(user);
            response.setMessage("stopMatch");
        }else{
            response.setOk(false);
            response.setReason("非法的匹配请求");
        }
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
    }

    @Override
    //异常连接处理
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        User user = (User) session.getAttributes().get("user");
        try{
            WebSocketSession tmpSession = onlineUserManager.getGameHallSession(user.getUserId());
            if(tmpSession == session){
                onlineUserManager.exitGameHall(user.getUserId());
            }
            //TODO 从匹配器中移除
            match.remove(user);
            System.out.println("玩家"+ user.getUsername() +"离开游戏大厅");
        }catch (NullPointerException e){
            System.out.println("[handleTransportError]当前用户尚未登录");
        }
    }

    @Override
    //处理玩家断开连接
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        User user = (User) session.getAttributes().get("user");
        try{
            WebSocketSession tmpSession = onlineUserManager.getGameHallSession(user.getUserId());
            if(tmpSession == session){
                onlineUserManager.exitGameHall(user.getUserId());
            }
            //TODO 从匹配器中移除
            match.remove(user);
            System.out.println("玩家"+ user.getUsername() +"离开游戏大厅");
        }catch (NullPointerException e){
            System.out.println("[afterConnectionClosed]当前用户尚未登录");
        }

    }
}
