/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 16:21
 * @Version 1.0
 */
package com.example.java_gobang.game;

import com.example.java_gobang.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

@Component
//匹配器
public class Match {
    @Autowired
    private OnlineUserManager onlineUserManager;

    @Autowired
    private RoomManager roomManager;

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
            synchronized (normalQueue){
                normalQueue.offer(user);
                normalQueue.notify();
            }
            System.out.println("玩家" + user.getUsername() + "进入normalQueue");
        }else if(user.getScore() >= 2000 && user.getScore() < 3000){
            synchronized (highQueue){
                highQueue.offer(user);
                highQueue.notify();
            }
            System.out.println("玩家" + user.getUsername() + "进入highQueue");
        }else{
            synchronized (veryHighQueue){
                veryHighQueue.offer(user);
                veryHighQueue.notify();
            }
            System.out.println("玩家" + user.getUsername() + "进入veryHighQueue");
        }
    }


    public void remove(User user){
        if(user.getScore() < 2000){
            synchronized (normalQueue){
                normalQueue.remove(user);
            }
            System.out.println("玩家" + user.getUsername() + "退出normalQueue");
        }else if(user.getScore() >= 2000 && user.getScore() < 3000){
            synchronized (highQueue){
                highQueue.remove(user);
            }
            System.out.println("玩家" + user.getUsername() + "退出highQueue");
        }else{
            synchronized (veryHighQueue){
                veryHighQueue.remove(user);
            }
            System.out.println("玩家" + user.getUsername() + "退出veryHighQueue");
        }
    }

    //启动三个线程循环调用各自的队列
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
        synchronized (matchQueue){
            try{
                //五子棋需要两个人，当队列中人数少于2时等待
                while(matchQueue.size() < 2){
                    matchQueue.wait();
                }
                User user1 = matchQueue.poll();
                User user2 = matchQueue.poll();

                WebSocketSession session1 = onlineUserManager.getGameHallSession(user1.getUserId());
                WebSocketSession session2 = onlineUserManager.getGameHallSession(user2.getUserId());
                if(session1 == null){
                    matchQueue.add(user2);
                    return;
                }
                if(session2 == null){
                    matchQueue.add(user1);
                    return;
                }
                //防止多开
                if (session1 == session2){
                    matchQueue.add(user1);
                }

                //TODO 将两个玩家加入对战房间
                Room room = new Room();
                roomManager.add(user1.getUserId(),user2.getUserId(),room);


                //给玩家1发送匹配成功的信息
                MatchResponse response1 = new MatchResponse();
                response1.setMessage("MatchSuccess");
                session1.sendMessage(new TextMessage(objectMapper.writeValueAsString(response1)));
                //给玩家2发送匹配成功的信息
                MatchResponse response2 = new MatchResponse();
                response2.setMessage("MatchSuccess");
                session2.sendMessage(new TextMessage(objectMapper.writeValueAsString(response2)));
            }catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
