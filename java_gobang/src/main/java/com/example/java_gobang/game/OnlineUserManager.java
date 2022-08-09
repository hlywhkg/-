/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 15:01
 * @Version 1.0
 */
package com.example.java_gobang.game;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

@Component
//这个类用来管理用户的在线状态
public class OnlineUserManager {
    private ConcurrentHashMap<Integer, WebSocketSession> game_hall = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, WebSocketSession> game_room = new ConcurrentHashMap<>();

    //用户进入游戏大厅
    public void enterGameHall(int userId,WebSocketSession session){
        game_hall.put(userId,session);
    }

    //用户离开游戏大厅
    public void exitGameHall(int userId){
        game_hall.remove(userId);
    }

    //获取用户信息
    public WebSocketSession getGameHallSession(int userId){
        return game_hall.get(userId);
    }

    //用户进入游戏房间
    public void enterGameRoom(int userId,WebSocketSession session){
        game_room.put(userId,session);
    }

    //用户离开游戏房间
    public void exitGameRoom(int userId){
        game_room.remove(userId);
    }

    //获取用户信息
    public WebSocketSession getGameRoomSession(int userId){
        return game_room.get(userId);
    }

}
