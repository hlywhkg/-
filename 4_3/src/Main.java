import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/3 9:10
 * @Version 1.0
 */

public class Main {
    public static boolean isP(int x){
        for (int i = 2 ; i < x / 2 ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        for (int i = x / 2; i <= x; i++) {
            int size = x - i;
            if(isP(i) && isP(size)){
                System.out.println(i);
                System.out.println(size);
                break;
            }
        }
    }
}
