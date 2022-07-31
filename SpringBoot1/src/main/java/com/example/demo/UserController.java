/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/31 21:04
 * @Version 1.0
 */
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("/sayhi")
    public String sayHi(){
        return "hello , world.";
    }
}
