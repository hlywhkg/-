/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 10:26
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("hello , Component");
    }
}
