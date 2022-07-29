import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/20 14:34
 * @Version 1.0
 */
@WebServlet("/Header")
public class SetHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh","3");
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("时间: " + System.currentTimeMillis());
    }
}
