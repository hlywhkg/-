/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.service;

import com.example.demo.controller.FavoriteController;
import com.example.demo.controller.LikeController;
import com.example.demo.model.*;
import com.example.demo.util.ResultData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private LikeMapper likeMapper;

    @Resource
    private FavoriteMapper favoriteMapper;

    @Resource
    private LikeController likeController;

    @Resource
    private FavoriteController favoriteController;

    private static final String LIKE = "like:list:userId:";
    private static final String FAVORITE = "favorite:list:userId:";
    private static final String CANCEL_LIKE = "cancelLike:list:userId";
    private static final String CANCEL_FAVORITE = "cancelFavorite:list:userId";

    public Object selectAllBlogs(String blogId) {
        if (blogId == null || "".equals(blogId)) {
            List<Blog> blogs = blogMapper.selectAllBlogs();
            for (Blog blog : blogs) {
                if (blog.getBlog_content().length() > 50) {
                    blog.setBlog_content(blog.getBlog_content().substring(0, 50) + "...");
                }
            }
            return blogs;
        } else {
            int blogId1 = Integer.parseInt(blogId);
            if (blogId1 < 1) {
                return ResultData.fail("blogId异常");
            }
            Blog blog = blogMapper.selectBlogByBlogId(blogId1);
            if (blog == null) {
                return ResultData.fail("不存在当前id的博客");
            }
            return blog;
        }
    }

    public Object insertBlog(User user,String title,
                           String content,HttpServletResponse resp) throws IOException {
        if(title == null || "".equals(title) || content == null || "".equals(content)){
            return ResultData.fail("参数缺失");
        }
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setTitle(title);
        blog.setBlog_content(content);
        blogMapper.insert(blog);
        System.out.println("insert:blogId:"+blog.getBlogId());
        resp.sendRedirect("blog_person.html");
        return ResultData.ok(200,"发布博客成功");
    }

    public Blog selectBlogByBlogId(Integer blogId){
        return blogMapper.selectBlogByBlogId(blogId);
    }

    public List<Blog> selectBlogsByUserId(Integer userId){
        return blogMapper.selectAllBlogByUserId(userId);
    }

    public Object delBlogByBlogId(User user,
                                String blogId,HttpServletResponse response) throws IOException {
        if(blogId == null || "".equals(blogId)){
            return ResultData.fail("参数残缺");
        }
        int blogId1 = Integer.parseInt(blogId);
        Blog blog = blogMapper.selectBlogByBlogId(blogId1);
        if(blog == null){
            return ResultData.fail("要删除的博客不存在");
        }
        //保险一点,虽然前端已经做了判定
        if(user.getUserId() != blog.getUserId()){
            return ResultData.fail("您不是该博客的作者,无法删除");
        }
        blogMapper.delBlogByBlogId(blog.getBlogId());
        likeMapper.deleteBlog(blog.getBlogId());
        favoriteMapper.deleteBlog(blog.getBlogId());
        response.sendRedirect("blog_person.html");
        return ResultData.ok(200,"删除成功");
    }

    public Object isLike(User user,Integer blogId){
        Boolean isLike = redisTemplate.opsForSet().isMember(LIKE + blogId,user.getUserId());
        System.out.println(isLike);
        if(!isLike){
            isLike = likeController.IsLike(blogId,user.getUserId());
            System.out.println("isLike:"+isLike);
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("like",isLike);
        return map;
    }

    public void likeBlog(User user, Integer blogId,Boolean isLike){
        Blog blog = blogMapper.selectBlogByBlogId(blogId);
        if (!isLike) {
            System.out.println(LIKE + blogId);
            redisTemplate.opsForSet().add(LIKE + blogId,user.getUserId());
            redisTemplate.opsForSet().remove(CANCEL_LIKE + blogId,user.getUserId());
        } else {
            System.out.println("like:list:userId:"+blogId);
            redisTemplate.opsForSet().remove(LIKE + blogId,user.getUserId());
            redisTemplate.opsForSet().add(CANCEL_LIKE + blogId,user.getUserId());
        }
    }

    public Object isFavorite(User user,Integer blogId){
        Boolean isFavorite = redisTemplate.opsForSet().isMember(FAVORITE + blogId,user.getUserId());
        if(!isFavorite) {
            isFavorite = favoriteController.IsFavorite(blogId, user.getUserId());
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("favorite",isFavorite);
        return map;
    }

    public void favoriteBlog(User user, Integer blogId,Boolean isFavorite){
        Blog blog = blogMapper.selectBlogByBlogId(blogId);
        if (!isFavorite) {
            System.out.println(FAVORITE + blogId);
            redisTemplate.opsForSet().add(FAVORITE + blogId,user.getUserId());
            redisTemplate.opsForSet().remove(CANCEL_FAVORITE + blogId,user.getUserId());
        } else {
            System.out.println(FAVORITE+blogId);
            redisTemplate.opsForSet().remove(FAVORITE + blogId,user.getUserId());
            redisTemplate.opsForSet().add(CANCEL_FAVORITE + blogId,user.getUserId());
        }
    }
}
