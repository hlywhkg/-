import java.util.Arrays;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/1 10:39
 * @Version 1.0
 */


class Solution5 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 1 ; i < m ; i++){
            dp[i][0] = 1;
        }
        for(int j = 1 ; j < n ; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1 ; j < n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

class Solution4 {
    public int climbStairs(int n) {
        if(n == 1)return 1;
        int first = 1;
        int second = 2;
        int third = 0;
        for(int i = 3 ; i <= n ; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

class Solution3 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size() * 2;
        int[] nums = new int[n];
        for (int i = 0, idx = 0; i < n / 2; i++, idx += 2) {
            String[] ss = timePoints.get(i).split(":");
            int h = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
            nums[idx] = h * 60 + m;
            nums[idx + 1] = nums[idx] + 1440;
        }
        Arrays.sort(nums);
        int ans = nums[1] - nums[0];
        for (int i = 0; i < n - 1; i++) ans = Math.min(ans, nums[i + 1] - nums[i]);
        return ans;
    }
}

class Solution2 {
    public int findDuplicate(int[] nums) {
        int fast = 0,slow = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}

class Solution1 {
    public int findDuplicate(int[] nums) {
        int x = 0;
        for(int i = 1 ; i < nums.length; i++) {
            x ^= i;
        }
        for(int i = 0 ; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }
}

public class demo {
    public static void main(String[] args) {
        /*System.out.println(2^3^4^5^3^7^9);*/
        Solution1 s = new Solution1();
        System.out.println(s.findDuplicate(new int[]{1, 2, 3, 4, 5, 5, 6}));
    }
}
