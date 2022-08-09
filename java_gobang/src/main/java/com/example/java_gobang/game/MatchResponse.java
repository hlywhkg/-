/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 15:25
 * @Version 1.0
 */
package com.example.java_gobang.game;

import lombok.Data;

@Data
public class MatchResponse {
    private boolean ok = true;
    private String reason = "";
    private String message = "";
}
