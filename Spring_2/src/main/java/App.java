import com.bean.User.UserComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 9:28
 * @Version 1.0
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        /*UserController user = (UserController) context.getBean("userController");
        user.sayHi();*/

        /*UserService user = context.getBean(UserService.class);
        user.sayHi();*/

        /*UserConfiguration user = context.getBean(UserConfiguration.class);
        user.sayHi();*/

        /*UserRepository user = context.getBean(UserRepository.class);
        user.sayHi();*/

        /*UserComponent user = context.getBean(UserComponent.class);
        user.sayHi();*/
    }
}
