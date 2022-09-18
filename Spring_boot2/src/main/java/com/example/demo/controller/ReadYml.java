/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 14:47
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class ReadYml {
    @Value("${string.str1}")
    private String str1;

    @Value("${string.str2}")
    private String str2;

    @Value("${string.str3}")
    private String str3;

    @PostConstruct
    public void PostConstruct(){
        System.out.println("str1 : " + str1);
        System.out.println("str2 : " + str2);
        System.out.println("str3 : " + str3);
    }
}
