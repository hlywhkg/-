import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/15 10:03
 * @Version 1.0
 */

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String r = sc.nextLine();
        int n = r.charAt(0)-48;
        int t = r.charAt(2)-48;
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 1 ; i <= n ;i++) {
            map.put(i,new int[]{i,i});
        }
        for(int j = 0; j < t; j++) {
            String s = sc.nextLine();
            char a = s.charAt(0);
            int b = s.charAt(2)-48;
            int[] ret = map.get(b);
            int x = ret[0],y = ret[1];
            if(a == 'Q'){
                System.out.println(x +" " + y);
            }else if(a == 'L'){
                if(b <= 1){
                    continue;
                }
                int[] tmp = map.get(b-1);
                map.put(y,new int[]{tmp[0],y});
            }else if(a == 'R'){
                if(b >= n){
                    continue;
                }
                int[] tmp = map.get(b+1);
                map.put(y,new int[]{x,tmp[1]});
            }
        }
    }
}
