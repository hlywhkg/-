import com.beans.BeanLifeComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 13:12
 * @Version 1.0
 */

public class App2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanLifeComponent beanLifeComponent = context.getBean(BeanLifeComponent.class);
        beanLifeComponent.use();
        context.destroy();
    }
}
