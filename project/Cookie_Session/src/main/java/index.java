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
 * @date 2022/7/22 15:20
 * @Version 1.0
 */
@WebServlet("/index")
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");
        //获取次数
        Integer count = (Integer)session.getAttribute("count");
        count += 1;
        //写回会话里
        session.setAttribute("count",count);
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("<h3>欢迎您" + username + "这是您第" + count +"次访问此页面</h3>");
    }
}
