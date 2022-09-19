/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.service.BlogService;
import com.example.demo.util.ResultData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;


    /**
     * 获取博客列表
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    public Object selectAll(String blogId) {
        if (blogId == null || "".equals(blogId)) {
            return blogService.selectAll();
        }else{
            int blogId1 = Integer.parseInt(blogId);
            if(blogId1 < 1){
                return ResultData.fail("blogId异常");
            }
            Blog blog = blogService.selectByBlogId(blogId1);
            if(blog == null){
                return ResultData.fail("不存在当前id的博客");
            }
            return blog;
        }
    }

    /**
     * 用来发布博客
     */
    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    public Object insertBlog(@SessionAttribute(value = "user")User user,String title,
                             String content,HttpServletResponse resp) throws IOException {
        if(title == null || "".equals(title) || content == null || "".equals(content)){
            return ResultData.fail("参数缺失");
        }
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setTitle(title);
        blog.setBlog_content(content);
        blogService.insert(blog);
        resp.sendRedirect("blog_list.html");
        return ResultData.ok(200,"发布博客成功");
    }

    /**
     * 用来删除博客
     */
    @RequestMapping(value = "/blogDel",method = RequestMethod.GET)
    public Object delByBlogId(@SessionAttribute(value = "user")User user,
                              String blogId,HttpServletResponse response) throws IOException {
        if(blogId == null || "".equals(blogId)){
            return ResultData.fail("参数残缺");
        }
        int blogId1 = Integer.parseInt(blogId);
        Blog blog = blogService.selectByBlogId(blogId1);
        if(blog == null){
            return ResultData.fail("要删除的博客不存在");
        }
        //保险一点,虽然前端已经做了判定
        if(user.getUserId() != blog.getUserId()){
            return ResultData.fail("您不是该博客的作者,无法删除");
        }
        blogService.deleteByBlogId(blog.getBlogId());
        response.sendRedirect("blog_list.html");
        return ResultData.ok(200,"删除成功");
    }


}
