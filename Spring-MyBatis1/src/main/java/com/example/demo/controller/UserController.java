/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/5 20:57
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id){
        if(id == null)return null;
        return userService.getUserById(id);
    }
}
