/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/28 21:21
 * @Version 1.0
 */
package Controller;

import Dao.blogDao;
import Dao.userDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Blog;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorInfo")
public class BlogGetAuthorNameServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        String blogId = req.getParameter("blogId");
        if(blogId == null || "".equals(blogId)){
            resp.getWriter().write("{\"ok\":false, \"reason\":\"参数缺失\" }");
            return;
        }
        //根据博客id获取到一个博客对象，博客对象内存有作者id
        Blog blog = blogDao.select(Integer.parseInt(blogId));
        if(blog == null){
            resp.getWriter().write("{\"ok\": false,\"reason\":\"要查找的博客不存在\"}");
            return;
        }
        //根据作者id查询作者
        User user = userDao.selectByUserId(blog.getUserId());
        if(user == null){
            resp.getWriter().write("{\"ok\": false,\"reason\":\"要查找的作者不存在\"}");
            return;
        }
        user.setPassword("");
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
