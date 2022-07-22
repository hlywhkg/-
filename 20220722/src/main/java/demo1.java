/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/22 10:53
 * @Version 1.0
 */

import java.util.*;

class Main {
    public static int c(int x, int y){
        if(x % y == 0)return y;
        int max = 1;
        for(int i = 2 ; i < y ; i++){
            if(x % i == 0 && y % i == 0 && max < i){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int a = in.nextInt();
            for(int i = 0; i < n ; i++){
                int b = in.nextInt();
                if(a >= b){
                    a += b;
                }else{
                    a += c(b,a);
                }
            }
            System.out.println(a);
        }
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            Map<Character,Boolean> map = new HashMap<>();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),false);
                }else{
                    map.put(str.charAt(i),true);
                }
            }
            boolean flg = true;
            for (int i = 0; i < n; i++) {
                if(map.get(str.charAt(i)) && flg){
                    System.out.println(str.charAt(i));
                    flg = false;
                }
            }
            if (flg) System.out.println(-1);
        }
    }
}

public class demo1 {

}
