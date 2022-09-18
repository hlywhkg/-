/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/18 16:36
 * @Version 1.0
 */
package com.example.demo.intercept;

import com.example.demo.util.ResultData;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            return true;
        }
        response.setStatus(401);
        response.sendRedirect("/login.html");
        return false;
    }
}
