/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/3 15:14
 * @Version 1.0
 */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

public class demo1 {
    public static void main(String[] args) {

    }
}
