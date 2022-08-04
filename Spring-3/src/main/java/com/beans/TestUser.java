/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 13:45
 * @Version 1.0
 */
package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class TestUser {
    @Autowired
    private Test test;

    public TestUser(){
        test.sayHi();
        System.out.println("TestUser->调用构造方法");
    }
}
