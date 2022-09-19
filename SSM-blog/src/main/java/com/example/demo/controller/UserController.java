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

    @Autowired
    private BlogService blogService;

    /**
     * 用来登录
     * @param user
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(user == null || "".equals(user.getUsername()) || "".equals(user.getPassword())){
            return ResultData.fail("用户尚未登录");
        }
        User user1 = userService.selectByName(user.getUsername());
        if(!user.getPassword().equals(user1.getPassword())){
            return ResultData.fail("用户名或密码错误");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user1);
        response.sendRedirect("blog_list.html");
        return ResultData.ok(200,"ok");
    }

    /**
     * 用来验证登录
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
        if(blogId == null || "".equals(blogId)){
            return ResultData.fail("参数缺失");
        }
        int blogId1 = Integer.parseInt(blogId);
        if(blogId1 < 1){
            return ResultData.fail("博客id参数异常");
        }
        Blog blog = blogService.selectByBlogId(blogId1);
        if(blog == null){
            return ResultData.fail("该博客不存在");
        }
        User author = userService.selectById(blog.getUserId());
        if(author == null){
            return ResultData.fail("要查找的作者不存在");
        }
        author.setPassword("");
        return author;
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
        HttpSession session = req.getSession(false);
        if(session == null){
            return ResultData.fail("用户尚未登录,无法注销");
        }
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
        return ResultData.ok(200,"注销成功");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object userRegister(@RequestBody Register register) throws IOException {
        User user = userService.selectByName(register.username);
        if (user != null) {
            return ResultData.fail("repeat");
        }
        User user1 = new User();
        user1.setUsername(register.username);
        user1.setPassword(register.password1);
        userService.insert(user1);
        return ResultData.ok(200,"ok");
    }

}
