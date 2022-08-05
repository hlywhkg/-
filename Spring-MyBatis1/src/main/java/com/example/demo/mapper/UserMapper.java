/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/5 20:43
 * @Version 1.0
 */
package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public UserInfo getUserById(@Param("id") Integer id);
}
