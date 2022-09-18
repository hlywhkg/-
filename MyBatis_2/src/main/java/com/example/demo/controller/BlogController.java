/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;


    @RequestMapping("/blog")
    public Object selectAll(HttpServletRequest request) {
        String str = request.getParameter("blogId");
        if (str == null) {
            return blogService.selectAll();
        }else{
            int blogId = Integer.parseInt(str);
            if(blogId < 1){
                return ResultData.fail("blogId异常");
            }
            Blog blog = blogService.selectByBlogId(blogId);
            if(blog == null){
                return ResultData.fail("不存在当前id的博客");
            }
            return blog;
        }
    }

}
