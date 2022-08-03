/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 13:39
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class UserBean2 {
    @Bean(name = "User1")
    public User user1(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    @Bean(name = "User2")
    public User user2(){
        User user = new User();
        user.setId(2);
        user.setName("李四");
        return user;
    }

}
