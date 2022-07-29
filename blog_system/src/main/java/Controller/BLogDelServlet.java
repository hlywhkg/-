/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/29 11:07
 * @Version 1.0
 */
package Controller;

import Dao.blogDao;
import entity.Blog;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/blogDel")
public class BLogDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、检查当前用户是否登录
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前您处于未登录状态，无法进行删除操作！");
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("当前您处于未登录状态，无法进行删除操作！");
            return;
        }
        // 2、获取到参数中的 blogId
        String blogId = req.getParameter("blogId");
        if (blogId == null || "".equals(blogId)){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("参数残缺，无法进行删除操作！");
            return;
        }
        // 3、获取需要删除的博客信息
        Blog blog = blogDao.select(Integer.parseInt(blogId));
        if (blog == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("您要删除的博客不存在，无法进行删除操作！");
            return;
        }
        // 4、再次校验：当前的用户是否是博客的作者
        if(user.getUserId() != blog.getUserId()){
            // 虽然在前端中处理过这个问题，但是再稳一波，twin check 更保险！
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("非法删除操作！");
            return;
        }
        // 5、删除指定博客
        blogDao.delete(Integer.parseInt(blogId));
        // 6、返回一个重定向响应
        resp.sendRedirect("blog_list.html");
    }
}
