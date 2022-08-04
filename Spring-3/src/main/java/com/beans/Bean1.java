/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 9:38
 * @Version 1.0
 */
package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Bean1 {

    @Autowired
    private User user;


    public User getUser(){
        System.out.println("Bean1对象未修改name之前 ： "+user);
        user.setName("C++");
        return user;
    }
}
