import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/30 18:14
 * @Version 1.0
 */

public class test {
    public static Integer max(int a,int b){
        if(a == 0 || b == 0){
            return null;
        }
        if(a < b){
            int tmp = a;
            a = b;
            b =tmp;
        }
        for(int i = b; i > 0;i--) {
            if(b % i != 0){
                continue;
            }
            if(b % i == 0 && a % i == 0){
                a = i;
                break;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(a * b / max(a,b));*/
        /*char c[] = {'a','b'};
        System.out.println(c);*/
        Integer a = 0;
        int b = 0;
        System.out.println(b == a);
        System.out.println(a.equals(b));
    }
}
