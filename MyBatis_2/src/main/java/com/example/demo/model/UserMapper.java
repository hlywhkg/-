/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 12:42
 * @Version 1.0
 */
package com.example.demo.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User user);
    User selectById(Integer userId);
    User selectByName(String username);
}
