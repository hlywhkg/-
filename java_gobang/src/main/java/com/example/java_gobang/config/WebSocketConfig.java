/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/8 18:19
 * @Version 1.0
 */
package com.example.java_gobang.config;

import com.example.java_gobang.api.GameAPI;
import com.example.java_gobang.api.MatchAPI;
import com.example.java_gobang.api.TestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Configuration
@EnableWebSocket//这个注释可以让Spring知道这是一个WebSocket配置类
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private TestAPI testAPI;

    @Autowired
    private MatchAPI matchAPI;

    @Autowired
    private GameAPI gameAPI;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //这个方法可以将一个消息处理器和一个路由关联上，访问这个路由后将使用testAPI的方法进行消息处理
        registry.addHandler(testAPI,"/test");
        //拦截器，可以获取到HttpSession中的session供webSocket中的session使用
        registry.addHandler(matchAPI,"/findMatch").
                addInterceptors(new HttpSessionHandshakeInterceptor());

        registry.addHandler(gameAPI,"/game").
                addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
