/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/6 22:05
 * @Version 1.0
 */

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] tmp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            tmp[i] = tmp[i-1] + chalk[i-1];
        }
        int count = (int)(k % tmp[n]);
        if(count == 0){
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if(tmp[i] > count){
                return i - 1;
            }
        }
        return 0;
    }
}

class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[]prev = new int[n+1];
        int[]next = new int[n+1];
        prev[0] = next[n+1] = 1;
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i-1] * nums[i-1];
        }
        for (int i = n ; i >= 1; i--){
            next[i] = next[i+1] * nums[i-1];
        }
        int[] ret = new int[n];
        for (int i = 1; i < n; i++) {
            ret[i-1] = prev[i-1] * next[i+1];
        }
        return ret;
    }
}

public class test {
}
