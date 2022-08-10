/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/10 11:21
 * @Version 1.0
 */
package com.example.java_gobang.api;

import com.example.java_gobang.game.*;
import com.example.java_gobang.model.User;
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

    @Override
    //处理用户连接房间成功
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        GameReadyResponse resp = new GameReadyResponse();
        User user = (User) session.getAttributes().get("user");
        if(user == null){
            resp.setOk(false);
            resp.setReason("当前用户尚未登录");
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
                room.setUser1(user);
                System.out.println("玩家2" + user.getUsername() + "准备就绪");

                //通知玩家1游戏就绪了
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
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
