/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 15:09
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.ListTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class ReadList {
    @Autowired
    private ListTest listTest;

    @PostConstruct
    public void say(){
        System.out.println(listTest);
    }

}
