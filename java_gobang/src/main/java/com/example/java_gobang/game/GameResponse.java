/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/10 10:58
 * @Version 1.0
 */
package com.example.java_gobang.game;

import lombok.Data;

@Data
public class GameResponse {
    private String message = "putChess";
    private int userId;
    private int row;
    private int col;
    private int winner;//获胜者id
}
