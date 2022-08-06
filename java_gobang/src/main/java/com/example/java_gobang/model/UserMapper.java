/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/6 21:11
 * @Version 1.0
 */
package com.example.java_gobang.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(User user);

    void selectByName(String name);
}
