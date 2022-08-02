/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/2 13:11
 * @Version 1.0
 */

import java.util.Scanner;

class Main {
    public static int check(int n){
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(i % 4 == 0 && i % 100 != 0){
                count++;
            }
        }
        return count;
    }
    public static boolean is(int n){
        if(n % 4 == 0 && n % 100 != 0){
            return true;
        }else{
            return false;
        }
    }
    public static StringBuilder be(int n){
        StringBuilder sb = new StringBuilder();
        if(n < 10) {
            sb.append("0");
        }
        sb.append(n);
        return sb;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            //以0000-12-31 星期天为基准
            int year = n;
            StringBuilder date = new StringBuilder();
            boolean flg = is(n);
            //计算该年第一天是星期几
            int day = ((check(n) + (n - 1) * 365) % 7) % 7 + 1;
            System.out.println(day);
            day = 3;
            //1月1元旦
            System.out.println(n + "-01-01");
            //1月第三个星期一 ：马丁路德金纪念日
            int days = 1 + 2 * 7 + (7 - day + 1) % 7;
            date = be(days);
            System.out.println(n + "-01-" + date);
            //2月第三个星期一：总统节
            day = (day + 31) % 7 + 1;
            days = 1 + 2 * 7 + (7 - day + 1) % 7;
            date = be(days);
            System.out.println(n + "-02-" + date);
            //5月最后一个星期一：阵亡将士纪念日
            day = day + 28 + 30 + 62;
            if(flg)day = day + 1;
            day = day % 7 + 1;
            if(day == 1){
                days -= 7;
            }else {
                days = days - day - 1;
            }
            date = be(days);
            System.out.println(n + "-05-" + date);
            //7月4号：美国国庆
            System.out.println(n + "-07-04");
            //9月第一个星期一：劳动节
            day = (30 + 62 + day) % 7 + 1;
            days = 1 + (7 - day + 1) % 7;
            date = be(days);
            System.out.println(n + "-09-" + date);
            //11月第四个星期四：感恩节
            day = (day + 61) % 7 + 1;
            days = 1 + 3 * 7 + (7 - day + 4) % 7;
            date = be(days);
            System.out.println(n + "-11-" + date);
            //12月25：圣诞节
            System.out.println(n + "-12-25");

        }
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = 2;
            System.out.print(a + " = ");
            while(b <= a){
                if(b == a){
                    System.out.println(b);
                    break;
                }else{
                    if(a % b == 0){
                        System.out.print(b + " * ");
                        a /= b;
                    }else{
                        b++;
                    }
                }
            }
        }
    }
}

public class demo3 {
}
