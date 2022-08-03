/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 18:29
 * @Version 1.0
 */

package com.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService2 {

    private UserService userService;

    @Autowired
    public UserService2(UserService userService){
        this.userService = userService;
    }

    public UserService2(UserService userService,int x){
        this.userService = userService;
    }

    public void sayHi(){
        userService.sayHi();
    }
}
