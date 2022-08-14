/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 14:58
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.xml.ws.Action;

@Controller
public class ReadBean {

    @Autowired
    private Student student;

    @PostConstruct
    public void sayHi(){
        System.out.println(student);
    }
}
