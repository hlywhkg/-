/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 12:37
 * @Version 1.0
 */
package com.example.demo.model;

import lombok.Data;

@Data
public class User {
    private int userId = 0;
    private String username = "";
    private String password = "";
}
