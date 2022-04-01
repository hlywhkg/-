import javax.xml.soap.SAAJResult;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/1 18:22
 * @Version 1.0
 */

public class test {
    public static int getLength(String str){
        int size = str.length();
        if(size <= 4){
            return 5;
        }else if(size >= 5 && size <= 7){
            return 10;
        }else{
            return 25;
        }
    }
    public static int isAlp(String str){
        int count1 = 0;
        int count2 = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(c >= 65 && c <= 90) {
                count1++;
            }
            if(c >= 97 && c <= 122) {
                count2++;
            }
        }
        if(count1 == 0 && count2 == 0){
            return 0;
        }else if(count1 > 0 && count2 == 0){
            return 10;
        }else if(count1 == 0 && count2 > 0){
            return 10;
        }else {
            return 20;
        }
    }
    public static int isNum(String str){
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(c - '0' >= 0 && c - '0'<= 9) {
                count++;
            }
        }
        if(count == 0){
            return 0;
        }else if(count == 1){
            return 10;
        }else{
            return 20;
        }
    }
    public static int isOk(String  str){
        String regex = "[a-zA-Z0-9]";
        str = str.replaceAll(regex,"");
        if(str.length() == 0){
            return 0;
        }else if(str.length() == 1){
            return 10;
        }else {
            return 25;
        }
    }
    public static int get(String str){
        if(isAlp(str) == 20 && isNum(str) > 0 && isOk(str) > 0){
            return 5;
        }else if(isAlp(str) == 10 && isNum(str) > 0 && isOk(str) > 0){
            return 3;
        }else if(isAlp(str) > 0 && isNum(str) > 0){
            return 2;
        }else
            return 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int a = isAlp(str);
        int b = isNum(str);
        int c = isOk(str);
        int d = getLength(str);
        int e = get(str);
        int sum = a+b+c+d+e;
        if(sum >= 90){
            System.out.println("VERY_SECURE");
        }else if(sum >= 80){
            System.out.println("SECURE");
        }else if(sum >= 70){
            System.out.println("VERY_STRONG");
        }else if(sum >= 60){
            System.out.println("STRONG");
        }else if(sum >= 50){
            System.out.println("AVERAGE");
        }else if(sum >= 25){
            System.out.println("WEAK");
        }else if(sum >= 0){
            System.out.println("VERY_WEAK");
        }
    }
}
