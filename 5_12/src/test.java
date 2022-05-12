import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/12 11:31
 * @Version 1.0
 */

class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str1 = scan.next();
            String str2 = scan.next();
            int count = 0;
            while(str1.contains(str2)){
                count++;
                str1 = str1.replaceFirst(str2,"");

            }
            System.out.println(count);
        }
    }
}
public class test {
    public static void main(String[] args) {
        Arrays.asList()
    }
}
