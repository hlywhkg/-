/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 20:45
 * @Version 1.0
 */
package com.example.demo.util;

import lombok.Data;

@Data
public class ResultData {
    private int state;
    private String message;

    public static ResultData fail(String message){
        ResultData resultData = new ResultData();
        resultData.setState(200);
        resultData.setMessage(message);
        return resultData;
    }

    public static ResultData ok(int state,String message){
        ResultData resultData = new ResultData();
        resultData.setState(state);
        resultData.setMessage(message);
        return resultData;
    }
}
