import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/13 15:44
 * @Version 1.0
 */

/**
 * get
 */

@WebServlet("/parameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String useId = req.getParameter("useId");
        String classId = req.getParameter("classId");
        resp.getWriter().write("useId = " + useId + ",classId = " + classId);
    }
}
