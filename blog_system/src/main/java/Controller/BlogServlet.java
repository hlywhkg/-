/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/27 20:24
 * @Version 1.0
 */
package Controller;

import Dao.blogDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Blog;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 有了这个类后，可以不需要在使用博客列表页的类和博客详情页的类
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("blogId");
        resp.setContentType("application/json; charset=utf8");
        if(str == null){
            List<Blog> blogs = blogDao.selectAll();
            String respJson = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(respJson);
        }else{
            int blogId = Integer.parseInt(str);
            Blog blog = blogDao.select(blogId);
            String respJson = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(respJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取会话
        HttpSession session = req.getSession(false);
        if(session == null){
            //未登录的用户不能发布博客
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户尚未登录，不能发布博客");
            return;
        }
        User user = (User)session.getAttribute("user");
        if(user == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前用户尚未登录，不能发布博客");
            return;
        }
        req.setCharacterEncoding("utf8");
        String title = req.getParameter("title");
        String content = req.getParameter("blog_content");
        if(title == null || "".equals(title) || content == null || "".equals(content)){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("{\"ok\": false, \"reason\":\"缺少必要的参数,发布博客失败\"}");
            return;
        }
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setTitle(title);
        blog.setBlog_content(content);
        blogDao.insert(blog);
        resp.sendRedirect("blog_list.html");
    }
}
