/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 10:19
 * @Version 1.0
 */
package com.bean.User;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    public void sayHi(){
        System.out.println("hello , Configuration");
    }
}
