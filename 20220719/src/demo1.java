/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/19 11:35
 * @Version 1.0
 */

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int n1 = a.length(),n2 = b.length(),max = 0,index1 = 0,index2 = 0;
            int[][] dp = new int[n1+1][n2+1];
            for(int i = 1 ; i <= n1 ; i++) {
                for (int j = 1 ; j <= n2 ; j++) {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                        if(dp[i][j] > max){
                            max = dp[i][j];
                            index1 = i - max;index2 = j - max;
                        }
                    }
                }
            }
            System.out.println(max);
            System.out.println(index1);
            System.out.println(index2);
            if(n1 >= n2){
                System.out.println(b.substring(index2,index2+max));
            }else{
                System.out.println(a.substring(index1,index1+max));
            }
        }
    }
}

public class demo1 {
}
