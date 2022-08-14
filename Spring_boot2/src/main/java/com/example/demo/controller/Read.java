/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 13:10
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
@Component
public class Read {
    @Value("${server.port}")
    private String port;

    @Value("${loginName}")
    private String name;

    @PostConstruct
    public void postConstruct() {
        System.out.println("port" + port);
        System.out.println("name " + name);
    }
}