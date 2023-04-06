/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 12:33
 * @Version 1.0
 */
package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class Blog {
    private int blogId;
    private String title;
    private String blog_content;
    private int userId;
    private Timestamp postTime;
    //新增博客点赞数
    private int count_like;
    //新增博客收藏数
    private int count_favorite;

    public String getPostTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }
}
