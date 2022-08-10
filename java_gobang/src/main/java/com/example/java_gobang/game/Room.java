/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 20:47
 * @Version 1.0
 */
package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Data
public class Room {
    @Autowired
    private RoomManager roomManager;

    @Autowired
    private OnlineUserManager onlineUserManager;

    @Autowired
    private UserMapper userMapper;

    private String roomId;

    private User user1;

    private User user2;

    // 先手方的用户 id
    private int whiteUserId = 0;
    // 棋盘, 数字 0 表示未落子位置. 数字 1 表示玩家 1 的落子. 数字 2 表示玩家 2 的落子
    private static final int MAX_ROW = 15;
    private static final int MAX_COL = 15;
    private int[][] chessBoard = new int[MAX_ROW][MAX_COL];

    public Room(){
        this.roomId = UUID.randomUUID().toString();
    }



}
