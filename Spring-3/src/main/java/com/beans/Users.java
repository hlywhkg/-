/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 9:27
 * @Version 1.0
 */
package com.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Users {

    @Bean
    /*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/
    @Scope("prototype")
    public User user1(){
        User user = new User();
        user.setId(1);
        user.setName("Java");
        return user;
    }
}
