/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 14:21
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    /*@RequestMapping("/say")*/
    /*@RequestMapping(value = "/say", method = RequestMethod.GET)*/
    @RequestMapping(value = "/say", method = RequestMethod.POST)
    public String say(){
        return "Hello World";
    }
}
