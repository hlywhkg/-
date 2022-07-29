/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/26 15:48
 * @Version 1.0
 */
package Dao;
import DBUtil.*;
import entity.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//这个类用来实现对博客表的增删查改
public class blogDao {
    /**
     * 插入博客
     * @param blog
     */
    public static void insert(Blog blog){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into blog values(null,?,?,?,now())";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,blog.getTitle());
            preparedStatement.setString(2,blog.getBlog_content());
            preparedStatement.setInt(3,blog.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    /**
     * 根据博客id查找博客
     * @param id
     */
    public static Blog select(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setBlog_content(resultSet.getString("blog_content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
        return null;
    }

    /**
     * 显示所有博客
     */
    public static List<Blog> selectAll(){
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog group by blogId desc";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                //此处不将文章全文显示，只显示前50字，为内容摘要
                String content = resultSet.getString("blog_content");
                if(content.length() > 50){
                    content = content.substring(0,50);
                }
                blog.setBlog_content(content);
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return blogs;
    }

    /**
     * 根据博客id删除博客
     * @param id
     */
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from blog where blogId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }
}
