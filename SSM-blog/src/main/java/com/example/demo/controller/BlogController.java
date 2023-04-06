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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
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
    public Object selectAllBlogs(String blogId) {
        return blogService.selectAllBlogs(blogId);
    }

    /**
     * 用来发布博客
     */
    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    public Object insertBlog(@SessionAttribute(value = "user")User user,String title,
                             String content,HttpServletResponse resp) throws IOException {
        return blogService.insertBlog(user, title, content, resp);
    }

    /**
     * 用来删除博客
     */
    @RequestMapping(value = "/blogDel",method = RequestMethod.GET)
    public Object delByBlogId(@SessionAttribute(value = "user")User user,
                              String blogId,HttpServletResponse response) throws IOException {
        return blogService.delBlogByBlogId(user, blogId, response);
    }


    /**
     * 判断当前用户是否点赞
     * @param user
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/isLike",method = RequestMethod.GET)
    public Object isLike(@SessionAttribute(value = "user")User user,Integer blogId){
        System.out.println("blogId:"+blogId);
        return blogService.isLike(user, blogId);
    }

    /**
     * 点赞
     */
    @RequestMapping(value = "/likeBlog",method = RequestMethod.POST)
    public void likeBlog(@SessionAttribute(value = "user")User user,Integer blogId,Boolean isLike){
        System.out.println("likeBlog:blogId:"+blogId);
        System.out.println("likeBlog:isLike:"+isLike);
        blogService.likeBlog(user,blogId,isLike);
    }

    /**
     * 判断当前用户是否收藏
     * @param user
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/isFavorite",method = RequestMethod.GET)
    public Object isFavorite(@SessionAttribute(value = "user")User user,Integer blogId){
        System.out.println("blogId:"+blogId);
        return blogService.isFavorite(user, blogId);
    }

    /**
     * 收藏
     */
    @RequestMapping(value = "/favoriteBlog",method = RequestMethod.POST)
    public void favoriteBlog(@SessionAttribute(value = "user")User user,Integer blogId,Boolean isLike){
        System.out.println("favoriteBlog:blogId"+blogId);
        System.out.println("favoriteBlog:isFavorite"+isLike);
        blogService.favoriteBlog(user,blogId,isLike);
    }




}
