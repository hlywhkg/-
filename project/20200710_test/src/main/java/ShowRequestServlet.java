import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/13 15:24
 * @Version 1.0
 */

/**
 * get
 */
@WebServlet("/ShowServlet")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        //获取协议的名称和版本
        sb.append(req.getProtocol());
        sb.append("<br>");
        //获取HTTP方法名称
        sb.append(req.getMethod());
        sb.append("<br>");
        //获取网络路径的一部分
        sb.append(req.getRequestURI());
        sb.append("<br>");
        //返回第一级路径
        sb.append(req.getContextPath());
        sb.append("<br>");
        //返回查询字符串的信息
        sb.append(req.getQueryString());
        sb.append("<br>");
        //获取请求报头，请求报头也是一个key/value结构
        //此方法是获取请求报头中所有的key值，返回一个枚举类型
        Enumeration<String> e = req.getHeaderNames();
        while(e.hasMoreElements()){
            String k = e.nextElement();
            //通过报头key值获取value值
            String v = req.getHeader(k);
            sb.append(k + ": " + v + "<br>");
        }
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write(sb.toString());
    }
}
