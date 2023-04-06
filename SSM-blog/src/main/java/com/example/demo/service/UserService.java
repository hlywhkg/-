/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 这个类用来处理关于用户的逻辑
 * ①用户登录
 * ②用户注册
 * ③用户注销
 * ④查询用户信息
 */

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;


    public Object login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(user == null || "".equals(user.getUsername()) || "".equals(user.getPassword())){
            return ResultData.fail("[login]用户尚未登录");
        }
        User user1 = userMapper.selectUserByUserName(user.getUsername());
        if(!user.getPassword().equals(user1.getPassword())){
            return ResultData.fail("用户名或密码错误");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user1);
        response.sendRedirect("blog_list.html");
        return ResultData.ok(200,"ok");
    }


    public Object getAuthorInfo(String blogId){
        if(blogId == null || "".equals(blogId)){
            return ResultData.fail("参数缺失");
        }
        int blogId1 = Integer.parseInt(blogId);
        if(blogId1 < 1){
            return ResultData.fail("博客id参数异常");
        }
        Blog blog = blogMapper.selectBlogByBlogId(blogId1);
        if(blog == null){
            return ResultData.fail("该博客不存在");
        }
        User author = userMapper.selectUserByUserId(blog.getUserId());
        if(author == null){
            return ResultData.fail("要查找的作者不存在");
        }
        author.setPassword("");
        return author;
    }


    public Object logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if(session == null){
            return ResultData.fail("用户尚未登录,无法注销");
        }
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
        return ResultData.ok(200,"注销成功");
    }


    public Object userRegister(@RequestBody Register register) throws IOException {
        User user = userMapper.selectUserByUserName(register.username);
        if (user != null) {
            return ResultData.fail("repeat");
        }
        User user1 = new User();
        user1.setUsername(register.username);
        user1.setPassword(register.password1);
        userMapper.insert(user1);
        return ResultData.ok(200,"ok");
    }


    public Object getBlogsByUserId(Integer userId){
        List<Blog> blogs = blogMapper.selectAllBlogByUserId(userId);
        for (Blog blog : blogs) {
            if (blog.getBlog_content().length() > 50) {
                blog.setBlog_content(blog.getBlog_content().substring(0, 50) + "...");
            }
        }
        return blogs;
    }
}
