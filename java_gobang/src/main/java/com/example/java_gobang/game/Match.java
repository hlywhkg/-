/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 16:21
 * @Version 1.0
 */
package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
//匹配器
public class Match {
    @Autowired
    private OnlineUserManager onlineUserManager;

    private ObjectMapper objectMapper = new ObjectMapper();

    //游戏玩家分为三档
    //第一档://2000以下(不含2000)
    //第二档://2000-3000(不含3000)
    //第三档://3000以上
    private Queue<User> normalQueue = new LinkedList<>();
    private Queue<User> highQueue = new LinkedList<>();
    private Queue<User> veryHighQueue = new LinkedList<>();

    public void add(User user){
        if(user.getScore() < 2000){
            normalQueue.add(user);
            System.out.println("玩家" + user.getUsername() + "进入normalQueue");
        }else if(user.getScore() >= 2000 && user.getScore() < 3000){
            highQueue.add(user);
            System.out.println("玩家" + user.getUsername() + "进入highQueue");
        }else{
            veryHighQueue.add(user);
            System.out.println("玩家" + user.getUsername() + "进入veryHighQueue");
        }
    }


    public void remove(User user){
        if(user.getScore() < 2000){
            normalQueue.remove(user);
            System.out.println("玩家" + user.getUsername() + "退出normalQueue");
        }else if(user.getScore() >= 2000 && user.getScore() < 3000){
            highQueue.remove(user);
            System.out.println("玩家" + user.getUsername() + "退出highQueue");
        }else{
            veryHighQueue.remove(user);
            System.out.println("玩家" + user.getUsername() + "退出veryHighQueue");
        }
    }

    private Match(){
        new Thread(){
            @Override
            public void run() {
                while(true){
                    handlerMatch(normalQueue);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    handlerMatch(highQueue);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    handlerMatch(veryHighQueue);
                }
            }
        }.start();
    }

    private void handlerMatch(Queue<User> matchQueue){

    }
}
