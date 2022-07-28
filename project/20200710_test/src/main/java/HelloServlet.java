import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/12 13:03
 * @Version 1.0
 */

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
    @Override
    /**
     * 这个方法是在tomcat捕捉到一个HTTP的一个get请求时做出的回调方法
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这行代码是让我们在开发者选项的控制台看到的话
        System.out.println("hello world");
        //这句是想让我们在页面上看到的话
        resp.getWriter().write("hello world");
        //resp.getWriter().write("hello world"+ System.currentTimeMillis() + "i am writing");
    }
}
