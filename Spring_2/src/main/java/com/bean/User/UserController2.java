/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 13:45
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController2 {

    @Autowired
    private User User1;

    @Autowired
    private User User2;

    public void sayHi(){
        System.out.println("User1->" + User1);
        System.out.println("User2->" + User2);
    }
}
