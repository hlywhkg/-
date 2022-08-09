/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 20:57
 * @Version 1.0
 */
package com.example.java_gobang.game;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoomManager {

    //存储所有的Room房间
    ConcurrentHashMap<String,Room> rooms = new ConcurrentHashMap<>();
    //存储用户和房间的关联关系
    ConcurrentHashMap<Integer ,String> userIdToRoomId = new ConcurrentHashMap<>();

    public void add(int user1Id,int user2Id,Room room){
        rooms.put(room.getRoomId(),room);
        userIdToRoomId.put(user1Id,room.getRoomId());
        userIdToRoomId.put(user2Id,room.getRoomId());
    }

    public void remove(int user1Id,int userId2,String roomId){
        rooms.remove(roomId);
        userIdToRoomId.remove(user1Id);
        userIdToRoomId.remove(userId2);
    }

    public Room getRoomByRoomId(String roomID){
        return rooms.get(roomID);
    }

    public Room getRoomByUserId(int userId){
        String roomId = userIdToRoomId.get(userId);
        if(roomId == null){
            return null;
        }
        return getRoomByRoomId(roomId);
    }
}
