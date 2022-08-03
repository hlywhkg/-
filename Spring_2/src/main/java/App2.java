import java.beans.Introspector;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 11:10
 * @Version 1.0
 */

public class App2 {
    public static void main(String[] args) {
        String name = "UserController";
        String name2 = "APIController";
        System.out.println(Introspector.decapitalize(name));
        System.out.println(Introspector.decapitalize(name2));
    }
}
