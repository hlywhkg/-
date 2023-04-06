/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/4 20:24
 * @Version 1.0
 */
package com.example.demo.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface FavoriteMapper {
    List<FavoriteListUserId> selectUserId(Integer blogId);
    void insert(Integer blogId,Integer userId);
    void delete(Integer blogId,Integer userId);
    void deleteBlog(Integer blogId);
}
