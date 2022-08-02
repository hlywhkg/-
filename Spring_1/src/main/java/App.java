import com.bean.UserBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/2 14:26
 * @Version 1.0
 */

public class App {
    public static void main(String[] args) {
        /*System.out.println("hello Spring");*/
        /*ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
        UserBean userBean = (UserBean) context.getBean("user");
        userBean.sayHi("张三");*/
        /*BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("Spring-config.xml"));
        UserBean userBean = (UserBean) beanFactory.getBean("user");*/
        /*userBean.sayHi("李四");*/

        /*ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
        UserBean userBean = context.getBean(UserBean.class);
        userBean.sayHi("张三");*/

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
        UserBean userBean = context.getBean("user",UserBean.class);
        userBean.sayHi("张三");
    }
}
