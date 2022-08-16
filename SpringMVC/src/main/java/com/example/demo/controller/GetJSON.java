/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 16:36
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class GetJSON {
    @RequestMapping("/json")
    public User getJson(@RequestBody User user){
        return user;
    }
}
