import javafx.application.Application;
import oic.bin.user;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/29 22:25
 * @Version 1.0
 */

public class App {
    public static void main(String[] args) {
        //System.out.println("你好,spring");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        user user = (user)context.getBean("user");
        user.sayHi("张三");
    }

}
