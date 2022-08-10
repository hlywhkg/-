/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/10 10:57
 * @Version 1.0
 */
package com.example.java_gobang.game;

import lombok.Data;

@Data
public class GameReadyResponse {
    private String message = "readyGame";
    private boolean ok = true;
    private String reason;
    private String roomId;
    private int thisUserId = 0;
    private int thatUserId = 0;
    private int whiteUserId = 0;
}
