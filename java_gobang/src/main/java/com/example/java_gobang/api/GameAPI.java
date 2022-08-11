/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/10 11:21
 * @Version 1.0
 */
package com.example.java_gobang.api;

import com.example.java_gobang.game.*;
import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;


@Component
public class GameAPI extends TextWebSocketHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RoomManager roomManager;

    @Autowired
    private OnlineUserManager onlineUserManager;

    @Autowired
    private UserMapper userMapper;

    @Override
    //处理用户连接房间成功
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        GameReadyResponse resp = new GameReadyResponse();
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            resp.setOk(false);
            resp.setReason("[afterConnectionEstablished]当前用户尚未登录");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));
            return;
        }
        Room room = roomManager.getRoomByUserId(user.getUserId());
        if(room == null){
            resp.setOk(false);
            resp.setReason("用户匹配尚未成功，不能开始游戏");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));
            return;
        }
        System.out.println("游戏连接 roomId = " + room.getRoomId() + " userID = " + user.getUserId());
        //判断游戏是否多开
        if(onlineUserManager.getGameHallSession(user.getUserId()) != null ||
            onlineUserManager.getGameRoomSession(user.getUserId()) != null){
            resp.setOk(false);
            resp.setReason("当前游戏禁止多开");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));
            return;
        }

        //更新用户会话
        //游戏大厅和游戏房间的会话是不一样的
        onlineUserManager.enterGameRoom(user.getUserId(),session);
        //一个房间有两个玩家，因此使用时需要考虑到线程安全
        synchronized (room){
            //设置use1为先手
            if(room.getUser1() == null){
                room.setUser1(user);
                room.setWhiteUserId(user.getUserId());
                System.out.println("玩家1" + user.getUsername() + "准备就绪");
                return;
            }
            if(room.getUser2() == null){
                room.setUser2(user);
                System.out.println("玩家2" + user.getUsername() + "准备就绪");

                //通知玩家1\2\游戏就绪了
                notifyGameReady(room,room.getUser1().getUserId(),room.getUser2().getUserId());
                notifyGameReady(room,room.getUser2().getUserId(),room.getUser1().getUserId());
                return;
            }
            resp.setOk(true);
            resp.setReason("房间已经满了");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(resp)));
        }

    }

    private void notifyGameReady(Room room,int thisUserId,int thatUserId) throws IOException {
        GameReadyResponse response = new GameReadyResponse();
        response.setOk(true);
        response.setThisUserId(thisUserId);
        response.setThatUserId(thatUserId);
        response.setWhiteUserId(room.getWhiteUserId());
        WebSocketSession session = onlineUserManager.getGameRoomSession(thisUserId);
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));
    }

    @Override
    //落子请求
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            return;
        }
        Room room = roomManager.getRoomByUserId(user.getUserId());
        room.putChess(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            return;
        }
        WebSocketSession session1 = onlineUserManager.getGameRoomSession(user.getUserId());
        if(session1 != session){
            System.out.println("当前会话不是游戏中玩家的会话");
            return;
        }
        System.out.println("连接出错 userId = " + user.getUserId());
        onlineUserManager.exitGameRoom(user.getUserId());
        noticeThatUserWin(user);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            return;
        }
        WebSocketSession session1 = onlineUserManager.getGameRoomSession(user.getUserId());
        if(session1 != session){
            System.out.println("当前会话不是游戏中玩家的会话");
            return;
        }
        System.out.println("用户退出 userId = " + user.getUserId());
        onlineUserManager.exitGameRoom(user.getUserId());
        noticeThatUserWin(user);
    }

    //如果玩家掉线通知对手获胜
    private void noticeThatUserWin(User user) throws IOException {
        Room room = roomManager.getRoomByUserId(user.getUserId());
        if(room == null){
            System.out.println("房间已经释放，无需通知");
            return;
        }
        User thatUser = room.getUser1() == user ? room.getUser2() : room.getUser1();
        WebSocketSession session = onlineUserManager.getGameRoomSession(thatUser.getUserId());
        if(session == null){
            //这情况意味着对手也掉线了
            System.out.println("该玩家已掉线，无需通知");
            return;
        }
        //发送响应通知对手
        GameResponse response = new GameResponse();
        response.setUserId(thatUser.getUserId());
        response.setWinner(thatUser.getUserId());
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(response)));

        //更新玩家分数
        userMapper.userWin(thatUser.getUserId());
        userMapper.userLose(user.getUserId());
        //销毁房间
        roomManager.remove(user.getUserId(),thatUser.getUserId(),room.getRoomId());
        System.out.println("游戏结束，房间已销毁 roomId" + room.getRoomId() + "获胜方" + user.getUserId());
    }
}
