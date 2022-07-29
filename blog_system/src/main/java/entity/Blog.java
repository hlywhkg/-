package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/26 15:42
 * @Version 1.0
 */

public class Blog {
    private int blogId;
    private String title;
    private String blog_content;
    private int userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTime() {
        //return postTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
