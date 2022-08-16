/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 15:27
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserGetMapping {
    @GetMapping("/say")
    public String say(){
        return "Hello world";
    }
}
