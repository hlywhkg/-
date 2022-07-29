import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/20 13:27
 * @Version 1.0
 */
class User{
    public String useId;
    public String classId;
}
@WebServlet("/PostGetParameter2")
public class PostJsonGetParameter extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此方法将其按照数据流的方式读取请求，将其转换为User对象
        //假设读取的数据为 { "userId" : "10" , "classId" : "20" }
        //将其转换为 key / value 然后与User类中的字段进行比较，
        //如何获取到的这些字段信息？通过反射，使用了类对象进行了获取
        //当与类中字段匹配时就赋予其值，如果没有则跳过
        User user = objectMapper.readValue(req.getInputStream(),User.class);
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("useId :" + user.useId + ", classId : " + user.classId);
    }
}
