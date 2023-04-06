/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Register;
import com.example.demo.model.User;
import com.example.demo.model.UserMapper;
import com.example.demo.service.BlogService;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 登录
     * @param user
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return userService.login(user, request, response);
    }

    /**
     * 验证登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Object login(@SessionAttribute(value = "user")User user){
        user.setPassword("");
        return user;
    }

    /**
     * 获取博客作者信息
     * @return
     */
    @RequestMapping(value = "/authorInfo",method = RequestMethod.GET)
    public Object getAuthorInfo(String blogId){
        return userService.getAuthorInfo(blogId);
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Object logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         return userService.logOut(req,resp);
    }

    /**
     *  注册
     * @param register
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object userRegister(@RequestBody Register register) throws IOException {
        return userService.userRegister(register);
    }

    /**
     * 获取当前登录用户所有博客
     *
     */

    @RequestMapping(value = "/authBlogs",method = RequestMethod.GET)
    public Object getBlogsByUserId(@SessionAttribute(value = "user")User user){
        System.out.println("userID:"+user.getUserId());
        return userService.getBlogsByUserId(user.getUserId());
    }
}
