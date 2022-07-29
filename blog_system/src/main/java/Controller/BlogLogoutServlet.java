/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/29 9:18
 * @Version 1.0
 */
package Controller;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/logout")
public class BlogLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null){
            //没有会话，就代表用户根本没有登录
            //就不必在注销了
            resp.getWriter().write("当前用户尚未登录，无法注销");
            return;
        }
        //我们之前约定登录页面时必须要session和user同时具备才算登录成功
        //现在我们只需破坏其中一个user就行了，至于为何不删除session
        //因为servlet没有提供删除会话的Api
        session.removeAttribute("user");
        resp.sendRedirect("login.html");
    }
}
