import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/8 21:27
 * @Version 1.0
 */

class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prev = new int[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            prev[i] = prev[i-1] + nums[i-1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = prev[i],y = x - k;
            if(map.containsKey(y)){
                count += map.get(y);
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return count;
    }
}

class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prev = new int[n+1];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            prev[i] += prev[i-1] + nums[i-1];
        }
        for (int i = 1; i <= n; i++) {
            int tmp = target + prev[i - 1];
            int bound = Arrays.binarySearch(prev, tmp);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

class Solution1 {
    public boolean isBoomerang(int[][] points) {
        int[] x = {points[1][0] - points[0][0],points[1][1] - points[0][1]};
        int[] y = {points[2][0] - points[0][0],points[2][1] - points[0][1]};
        return x[0] * y[1] - y[0]* x[1] != 0;
    }
}

public class demo1 {
}
