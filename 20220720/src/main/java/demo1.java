/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/20 9:50
 * @Version 1.0
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int n1 = a.length(),n2 = b.length(),max = 0;
            int[][] dp = new int[n1+1][n2+1];
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <=n2 ; j++) {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                        if(dp[i][j] > max){
                            max = dp[i][j];
                        }
                    }
                }
            }
            System.out.println(max);
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
            int len = str.length(),i = 0,j = len;
            char[] c = str.toCharArray();
            while(i < j){
                char ant = c[i];
                c[i] = c[j];
                c[j] = ant;
                i++;
                j--;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < len; k++) {
                sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}

public class demo1 {
}
