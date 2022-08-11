/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 20:47
 * @Version 1.0
 */
package com.example.java_gobang.game;

import com.example.java_gobang.JavaGobangApplication;
import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.UUID;

@Data
public class Room {

    //由于Room不能是唯一的，所以不能注入到Spring中，从而也不可以用 Autowired注入这三个bean
    private OnlineUserManager onlineUserManager;
    private RoomManager roomManager;
    private UserMapper userMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

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
        onlineUserManager = JavaGobangApplication.context.getBean(OnlineUserManager.class);
        roomManager = JavaGobangApplication.context.getBean(RoomManager.class);
        userMapper = JavaGobangApplication.context.getBean(UserMapper.class);
    }

    //用这个方法实现落子响应
    public void putChess(String message) throws IOException {
        GameRequest request = new GameRequest();
        GameResponse response = new GameResponse();
        request = objectMapper.readValue(message,GameRequest.class);
        int row = request.getRow();
        int col = request.getCol();
        //判断是谁下的字
        //做出约定：
        //①如果是玩家一，则下的子为1，
        //②是玩家而，则下的子是2
        int chess = request.getUserId() == user1.getUserId() ? 1 : 2;

        if(chessBoard[row][col] != 0){
            System.out.println("下的子有误" + request);
            return;
        }

        chessBoard[row][col] = chess;
        printBoard();
        //检查游戏是否结束
        int winner = checkWinner(chess,row,col);
        System.out.println(winner);
        response.setUserId(request.getUserId());
        response.setRow(row);
        response.setCol(col);
        response.setWinner(winner);
        WebSocketSession session1 = onlineUserManager.getGameRoomSession(user1.getUserId());
        WebSocketSession session2 = onlineUserManager.getGameRoomSession(user2.getUserId());

        if(session1 == null){
            response.setWinner(user2.getUserId());
            System.out.println("玩家2掉线");
        }

        if(session2 == null){
            response.setWinner(user1.getUserId());
            System.out.println("玩家1掉线");
        }

        //传回响应
        String respJson = objectMapper.writeValueAsString(response);
        if(session1 != null){
            session1.sendMessage(new TextMessage(respJson));
        }
        if(session2 != null){
            session2.sendMessage(new TextMessage(respJson));
        }

        //已经分出胜负
        if(response.getWinner() != 0){
            //更新数据
            userMapper.userWin(response.getWinner() == user1.getUserId() ? user1.getUserId() : user2.getUserId());
            userMapper.userLose(response.getWinner() == user1.getUserId() ? user2.getUserId() : user1.getUserId());
            //销毁房间
            roomManager.remove(user1.getUserId(),user2.getUserId(),roomId);
            System.out.println("游戏结束，房间已销毁 roomId" + roomId + "获胜方" + response.getWinner());
        }
    }

    private int checkWinner(int chess, int row, int col) {
        // 以 row, col 为中心
        for (int c = col - 4; c <= col; c++) {
            // 针对其中的一种情况, 来判定这五个子是不是连在一起了~
            // 不光是这五个子得连着, 而且还得和玩家落的子是一样~~ (才算是获胜)
            try {
                if (chessBoard[row][c] == chess
                        && chessBoard[row][c + 1] == chess
                        && chessBoard[row][c + 2] == chess
                        && chessBoard[row][c + 3] == chess
                        && chessBoard[row][c + 4] == chess) {
                    // 构成了五子连珠! 胜负已分!
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // 如果出现数组下标越界的情况, 就在这里直接忽略这个异常.
                continue;
            }
        }

        // 2. 检查所有列
        for (int r = row - 4; r <= row; r++) {
            try {
                if (chessBoard[r][col] == chess
                        && chessBoard[r + 1][col] == chess
                        && chessBoard[r + 2][col] == chess
                        && chessBoard[r + 3][col] == chess
                        && chessBoard[r + 4][col] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        // 3. 检查左对角线
        for (int r = row - 4, c = col - 4; r <= row && c <= col; r++, c++) {
            try {
                if (chessBoard[r][c] == chess
                        && chessBoard[r + 1][c + 1] == chess
                        && chessBoard[r + 2][c + 2] == chess
                        && chessBoard[r + 3][c + 3] == chess
                        && chessBoard[r + 4][c + 4] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        // 4. 检查右对角线
        for (int r = row - 4, c = col + 4; r <= row && c >= col; r++, c--) {
            try {
                if (chessBoard[r][c] == chess
                        && chessBoard[r + 1][c - 1] == chess
                        && chessBoard[r + 2][c - 2] == chess
                        && chessBoard[r + 3][c - 3] == chess
                        && chessBoard[r + 4][c - 4] == chess) {
                    return chess == 1 ? user1.getUserId() : user2.getUserId();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        // 胜负未分, 就直接返回 0 了.
        return 0;

    }

    private void printBoard() {
        System.out.println("打印棋盘信息" + roomId);
        System.out.println("------------------------");
        for(int r = 0 ; r < MAX_ROW ; r++){
            for (int c = 0; c < MAX_COL; c++) {
                System.out.print(chessBoard[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }


}
