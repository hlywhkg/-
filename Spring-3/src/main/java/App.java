import com.beans.Bean1;
import com.beans.Bean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 9:27
 * @Version 1.0
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Bean1 bean1 = context.getBean("bean1",Bean1.class);
        System.out.println(bean1.getUser());
        Bean2 bean2 = context.getBean("bean2",Bean2.class);
        System.out.println(bean2.getUser());
    }
}
