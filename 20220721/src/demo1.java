/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/21 10:44
 * @Version 1.0
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String str = in.next();
            int[] ans = new int[n];
            for(int i = 0 ; i < n ; i++){
                ans[i] = i + 1;
            }
            int i = 0 ,ins = 0,j = 0;
            if(n >= 4)j = 3;
            else j = n;
            for(int k = 0 ; k < str.length() ; k++){
                if(str.charAt(k) == 'U'){
                    int[] ret = U(n,i,j,ins);
                    i = ret[0];j = ret[1];ins = ret[2];
                }else{
                    int[] ret = D(n,i,j,ins);
                    i = ret[0];j = ret[1];ins = ret[2];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int q = i ; q <= j ; q++){
                sb.append(ans[q] + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            System.out.println(ans[ins]);
        }
    }
    public static int[] U(int n ,int start ,int end,int ins){
        if(n >= 4){
            if(start == ins){
                if(start == 0){
                    start = n - 4;
                    end = start + 3;
                    ins = end;
                }else{
                    start--;
                    end--;
                    ins = start;
                }
            }else{
                ins--;
            }
        }else{
            ins = (ins - 1 + n) % n;
        }
        return new int[]{start,end,ins};
    }
    public static int[] D(int n ,int start,int end,int ins){
        if(n >= 4){
            if(end == ins){
                if(end == n - 1){
                    start = 0;
                    end = start + 3;
                    ins = start;
                }else{
                    start++;
                    end++;
                    ins = end;
                }
            }else{
                ins++;
            }
        }else{
            ins = (ins + 1) % n;
        }
        return new int[]{start,end,ins};
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main1 {
    public static void shake(int[] ret){
        int n =ret.length,gap = n / 2;
        System.out.println(Arrays.toString(ret));
        int[]left = new int[gap],right = new int[gap];
        for(int i = 0, j = 0 ; i < gap ; i++,j++){
            left[i] = ret[i];
            right[j] = ret[gap+j];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int cnt1 = 0,cnt2 = 0;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                ret[i] = left[cnt1++];
            }else{
                ret[i] = right[cnt2++];
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int gap = in.nextInt();
            for(int i = 0 ; i < gap ; i++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[]ans = new int[2*n];
                for(int j = 0 ; j < 2 * n ; j++){
                    ans[j] = in.nextInt();
                }
                for(int z = 0 ; z < k ; z++){
                    shake(ans);
                    System.out.println(Arrays.toString(ans));
                }
                StringBuilder sb = new StringBuilder();
                for(int q = 0 ; q < ans.length ; q++){
                    sb.append(ans[q] + " ");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
            }
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("alehngej");
        System.out.println(sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
