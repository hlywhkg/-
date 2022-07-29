import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/20 14:43
 * @Version 1.0
 */
@WebServlet("/123")
public class SetHeader2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setStatus(302);
        resp.setHeader("Location","https://www.sogou.com");*/
        resp.sendRedirect("https://www.sogou.com");
    }
}
