/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/8 18:12
 * @Version 1.0
 */
package com.example.java_gobang.api;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
/**
 * 这是一个测试类
 * 继承自TextWebSocketHandler的类是一个webSocket消息处理类
 */
public class TestAPI extends TextWebSocketHandler {
    @Override
    //用户建立连接后触发的方法
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接成功");
    }

    @Override
    //收到文本消息后触发的方法
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("收到消息 : " + message.getPayload());
        session.sendMessage(new TextMessage("我收到了你的消息" + message.getPayload()));
    }

    @Override
    //触发异常后触发的方法
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("连接异常");
    }

    @Override
    //关闭连接后触发的方法
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("关闭连接");
    }
}
