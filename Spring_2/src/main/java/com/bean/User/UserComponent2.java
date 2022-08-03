/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 19:09
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent2 {
    private  UserComponent userComponent;

    @Autowired
    public void setUserComponent(UserComponent userComponent) {
        this.userComponent = userComponent;
    }

    public void sayHi(){
        userComponent.sayHi();
    }
}
