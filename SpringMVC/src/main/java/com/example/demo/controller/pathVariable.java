/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 17:33
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@ResponseBody
@Controller
public class pathVariable {

    @RequestMapping("/getpath/{name}/{password}")
    public String say(@PathVariable String name, @PathVariable String password){
        return "name : " + name + "password : " + password;
    }
}
