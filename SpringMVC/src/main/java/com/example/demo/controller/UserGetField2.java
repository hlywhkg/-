/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 16:20
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserGetField2 {

    @RequestMapping("/getField2")
    public String get(String name,String password){
        return "name : " + name + " password :" + password;
    }
}