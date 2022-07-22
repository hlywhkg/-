import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/22 15:09
 * @Version 1.0
 */
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("zhangsan".equals(username) && "123".equals(password)){
            HttpSession session = req.getSession(true);
            session.setAttribute("username",username);
            session.setAttribute("count",0);
            resp.sendRedirect("index");
        }else{
            resp.getWriter().write("login failed");
        }
    }
}
