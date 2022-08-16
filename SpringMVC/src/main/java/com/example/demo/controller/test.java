/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 20:42
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class test {
    @RequestMapping("test")
    public String say(){
        return "hello.html";
    }

    @ResponseBody
    @RequestMapping("test2")
    public String say2(){
        return "<h1>hello world</h1>";
    }

    @ResponseBody
    @RequestMapping("test3")
    public Map<String,String> say3(){
        Map<String,String> map = new HashMap<>();
        map.put("zhangsan","123");
        map.put("lisi","123");
        map.put("wangwu","123");
        map.put("tianliu","123");
        return map;
    }


}
