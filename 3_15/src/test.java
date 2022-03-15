import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/15 19:38
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java? characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        //2 .让代码和数据库进行链接
        Connection connection = dataSource.getConnection();

        //3 . 操作数据库
        String sql = "insert into student(id,name) values(11,'张三')";
        //光是一个String类型的sql还不够,需要把String类型包装成一个语句对象
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行sql

        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
        connection.close();
    }
}
