/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 13:46
 * @Version 1.0
 */
package com.beans;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Test {

    public Test(){
        System.out.println("Test->调用构造方法");
    }

    public void sayHi(){
        System.out.println("hello");
    }
}
