/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/28 11:03
 * @Version 1.0
 */
package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class BlogLoginServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个是针对请求得到的数据按照这个格式解析
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        /*测试代码*/
        System.out.println("username :" + username + "password :" + password);
        //如果用户名或密码为空
        if(username == null || "".equals(username) || password == null || ".".equals(password)){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码不能为空");
        } else{
            User user = userDao.selectByName(username);
            if(user == null || !user.getPassword().equals(password)){
                resp.setContentType("text/html; charset=utf8");
                resp.getWriter().write("用户名或密码错误");
            }else{
                //如果比较通过就创建会话
                HttpSession session = req.getSession(true);
                //把刚才的用户信息存才会话中
                session.setAttribute("user",user);
                resp.sendRedirect("blog_list.html");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        HttpSession session = req.getSession(false);
        if(session == null){
            //未登录状态
            User user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        //如果会话不为空，就判断一下user是否为null
        User user =(User)session.getAttribute("user");
        //判断user是否为空是为后续注销操作做准备的
        if(user == null){
            user = new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        user.setPassword("");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
