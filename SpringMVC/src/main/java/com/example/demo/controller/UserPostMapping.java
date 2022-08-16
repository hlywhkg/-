/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 15:30
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserPostMapping {
    @PostMapping("Post")
    public String say(){
        return "Post Hello World";
    }
}
