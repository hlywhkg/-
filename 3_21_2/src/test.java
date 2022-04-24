import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/21 19:38
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.next();
        String []str1 = ret.split(" ");
        String str2 = scanner.next();
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < str2.length(); i++) {
            set.add(str2.charAt(i));
        }
        for (int i = 0; i < str1.length; i++) {
            for (char tmp : set) {
                int length = str1[i].length();
                for (int j = 0; j < length; j++) {
                    if(tmp == str1[i].charAt(j)){
                        StringBuffer sb =
                    }
                }
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 3 * n - 2; i >= n - 1; i -= 2) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
