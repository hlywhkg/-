import com.bean.User.User;
import com.bean.User.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 11:35
 * @Version 1.0
 */

public class App3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user1 = context.getBean("userInfo",User.class);
        User user2 = context.getBean("user",User.class);
        User user3 = context.getBean("User",User.class);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }
}
