/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 9:42
 * @Version 1.0
 */
package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Bean2 {
    @Autowired
    private User user;

    public User getUser(){
        return user;
    }
}
