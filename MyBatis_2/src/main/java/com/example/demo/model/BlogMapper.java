/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 12:42
 * @Version 1.0
 */
package com.example.demo.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    int deleteByBlogId(Integer blogId);
    Blog selectByBlogId(Integer blogId);
    List<Blog> selectByUserId(Integer userId);
    int insert(Blog blog);
    List<Blog> selectAll();
}
