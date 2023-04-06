/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 12:42
 * @Version 1.0
 */
package com.example.demo.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface  BlogMapper {
    int delBlogByBlogId(Integer blogId);
    List<Blog> selectAllBlogByUserId(Integer userId);
    int insert(Blog blog);
    List<Blog> selectAllBlogs();
    Blog selectBlogByBlogId(Integer blogId);
    void updateLike(Integer liked,Integer blogId);
    void updateFavorite(Integer favorited,Integer blogId);
}
