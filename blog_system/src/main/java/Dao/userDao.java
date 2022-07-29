/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/26 15:48
 * @Version 1.0
 */
package Dao;

import DBUtil.DBUtil;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
    /**
     * 通过用户名查找用户信息
     * @param name
     * @return
     */
    public static User selectByName(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    /**
     * 通过用户id查找用户信息
     * @param id
     * @return
     */
    public static User selectByUserId(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
