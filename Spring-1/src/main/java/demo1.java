/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/30 13:58
 * @Version 1.0
 */

import java.util.*;
class Solution {
    /**
     *	正数数组中的最小不可组成和
     *	输入：正数数组arr
     *	返回：正数数组中的最小不可组成和
     */
    public int getFirstUnFormedNum(int[] arr) {
        int min = arr[0],max = 0,n = arr.length;
        int[] prev = new int[n + 1];
        //Arrays.sort(arr);

        for(int i = 0 ; i < n ; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
            prev[i+1] = arr[i] + prev[i];
            max += arr[i];
        }
        System.out.println(Arrays.toString(prev));
        System.out.println(max);
        System.out.println(min);
        boolean flg = true;
        for(int i = min + 1 ; i < max ; i++) {
            flg = true;
            for(int j = 1 ; j <= n && flg; j++){
                for(int k = 0 ; k < j && flg; k++){
                    int target = prev[j] - prev[k];
                    System.out.println("i" + i + " target" + target);
                    if(i == target || i == prev[j]){
                        flg = false;
                    }
                }
            }
            System.out.println(flg);
            if(flg){
                return i;
            }
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int count = 0;
            if(n == 0)break;
            while(n >= 2){
                n = (int) Math.ceil(n * 1.0 / 3);
                System.out.println(n);
                count++;
            }
            System.out.println(count);
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getFirstUnFormedNum(new int[]{3, 2, 4}));
    }
}
