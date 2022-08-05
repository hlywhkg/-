/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/5 20:34
 * @Version 1.0
 */
package com.example.demo.model;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String name;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;
}
