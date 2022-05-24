import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/24 19:46
 * @Version 1.0
 */

import java.util.Scanner;
class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n == 1 || n == 0){
            System.out.println("both");
        }
        String str[] = new String[n];
        for(int i = 0 ; i < n ; i++){
            str[i] = scan.nextLine();
        }
        boolean flg1 = false;
        boolean flg2 = false;
        for(int i = 0 ; i < n - 1 ; i++){
            if(str[i].compareTo(str[i+1]) <= 0){
                flg1 = true;
            }else{
                flg1 = false;
                break;
            }
        }
        for(int i = 0 ; i < n - 1 ; i++){
            if(str[i].length() <= str[i + 1].length()){
                flg2 = true;
            }else{
                flg2 = false;
                break;
            }
        }

        if(flg1 && flg2){
            System.out.println("both");
        }else if(flg1){
            System.out.println("lexicographically");
        }else if(flg2){
            System.out.println("lengths");
        }else{
            System.out.println("none");
        }

    }
}


public class test {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
    }
}
