/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 11:32
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/say")
    @ResponseBody
    public String sayHi(){
        return "hello world";
    }

}
