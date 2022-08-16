/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 20:06
 * @Version 1.0
 */
package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
@Slf4j
public class GetCookie {
    @RequestMapping("getcookie")
    public void getCookie(HttpServletRequest req, HttpServletResponse response){
        Cookie[] cookies = req.getCookies();
        String useAgent = req.getHeader("User-Agent");
        for (Cookie cookie : cookies) {
            log.info("name : " + cookie.getName() + " value : " + cookie.getValue());
            log.info(useAgent);
        }
    }

    @RequestMapping("cookie")
    public void Cookie(@CookieValue("message") String name){
        log.info("name : " + name);
    }

    @RequestMapping("header")
    public void Header(@RequestHeader("User-Agent") String header){
        log.info("header : " + header);
    }
}
