/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 20:27
 * @Version 1.0
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
public class SetSession {
    @RequestMapping("/session")
    public String session(HttpServletRequest req, HttpServletResponse response){
        HttpSession session = req.getSession(true);
        session.setAttribute("user","java");
        return "session存储成功";
    }

    @RequestMapping("/getsession")
    public String Session(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        String user = (String) session.getAttribute("user");
        return "user : " + user;
    }

    @RequestMapping("/getsession2")
    public String Session2(@SessionAttribute(value = "user",required = false) String user){
        return "user : " + user;
    }
}
