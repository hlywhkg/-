import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/22 18:06
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) {
        String str = "dshfaf";
        int x = str.charAt(0) - 'a';
        System.out.println(x);
        Map<Character,Boolean> map = new HashMap<>();
        map.put('a',true);
        System.out.println(map.get('a'));
    }
}
