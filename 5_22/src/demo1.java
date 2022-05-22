import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/22 16:38
 * @Version 1.0
 */

class point{
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
}
public class demo1 {
    public static void main(String[] args) {
        String str = "sgseg235251fa15tgq31rfq3";
        String regex = "[^0-9]";
        String[] ret = str.split(regex);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < ret.length ; i++) {
            if(ret[i] != " "){
                sb.append(ret[i]);
            }
        }
        System.out.println(sb.toString());
        Stack stack = new Stack();
        stack.add(1);
    }
}
