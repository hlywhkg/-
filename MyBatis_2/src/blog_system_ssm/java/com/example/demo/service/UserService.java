/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    public User selectById(Integer id){
        return userMapper.selectById(id);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }

    public User selectByName(String username){
        return userMapper.selectByName(username);
    }
}
