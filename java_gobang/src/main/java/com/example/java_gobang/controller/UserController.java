/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/9 11:02
 * @Version 1.0
 */
package com.example.java_gobang.controller;

import com.example.java_gobang.model.User;
import com.example.java_gobang.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
//这个类用来实现三个方法
//①注册  ②登录   ③获取用户信息
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Object login(String username, String password, HttpServletRequest req){
        User user = userMapper.selectByName(username);
        if(user == null || !user.getPassword().equals(password)){
            return new User();
        }
        System.out.println("登录" + username);
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);
        return user;
    }

    @PostMapping("/register")
    public Object register(String username,String password){
        User user = null;
        try {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            System.out.println("register" + username);
            int ret = userMapper.insert(user);
            System.out.println("受影响的行数" + ret);
            //可能会触发一个主键重复的异常
        }catch (org.springframework.dao.DuplicateKeyException e){
            user = new User();
            //System.out.println("用户名重复");
        }
        return user;
    }


    @GetMapping("/userInfo")
    public Object getUserInfo(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if(session == null){
            return new User();
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            return new User();
        }
        User newUser = userMapper.selectByName(user.getUsername());
        return newUser;
    }
}
