import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/27 14:25
 * @Version 1.0
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello");
    }
}

class main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long a = in.nextLong();
            long b = in.nextLong();
            double c = 2 * 3.14 * b;
            if(a > c){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
