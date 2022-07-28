/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/27 19:21
 * @Version 1.0
 */
package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Blog;
import Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/blog_content")
public class BlogContentServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("blogId");
        int blogId = Integer.parseInt(str);
        Blog blog = blogDao.select(blogId);
        String respJson = objectMapper.writeValueAsString(blog);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(respJson);
    }
}
