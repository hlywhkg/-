/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 13:22
 * @Version 1.0
 */
package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.BlogMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogService {

    @Resource
    private BlogMapper blogMapper;

    public int insert(Blog blog){
        return blogMapper.insert(blog);
    }

    public List<Blog> selectByUserId(Integer userId){
        return blogMapper.selectByUserId(userId);
    }

    public Blog selectByBlogId(Integer BlogId){
        return blogMapper.selectByBlogId(BlogId);
    }

    public void deleteByBlogId(Integer BlogId){
        blogMapper.deleteByBlogId(BlogId);
    }

    public List<Blog> selectAll(){
        return blogMapper.selectAll();
    }
}
