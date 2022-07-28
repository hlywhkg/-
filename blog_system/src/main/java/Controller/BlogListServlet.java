/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/27 11:04
 * @Version 1.0
 */
package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog_list")
public class BlogListServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        List<Blog> blogs = blogDao.selectAll();
        String respJson = objectMapper.writeValueAsString(blogs);
        resp.getWriter().write(respJson);
    }
}
