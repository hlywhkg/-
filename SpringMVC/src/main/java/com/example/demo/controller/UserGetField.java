/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 16:01
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserGetField {

    @RequestMapping("/getField")
    public String get(String name){
        return "name : " + name;
    }
}
