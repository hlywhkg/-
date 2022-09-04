import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/4 7:04
 * @Version 1.0
 */

class Solution4 {
    public int sumNums(int n) {
        int sum = n;
        //牛逼的短路效应终止循环条件
        boolean x = n > 1 && (sum += sumNums(n-1)) > 0;
        return sum;
    }
}

/**
 * 左外连接使左边有的右边没有的也能显示在表格中,只是数据为null
 * select Name as Customers from Customers left join Orders on Customers.id = Orders.CustomerId where Orders.id is null;
 */

class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2 ; i <= n ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[n];
    }
}

class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        //dp[i]代表以第i-1个数结尾的最大连续字串和
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n; i++) {
            if(dp[i-1] < 0){
                //如果之前的最大连续子和是负数,相加就没有意义,重开
                dp[i] = nums[i-1];
            }else{
                //如果大于0,判断与位于i-1下标的位置是否可以作为连续子和一部分
                dp[i] = Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            }
            if(max < dp[i]){
                max = dp[i];
            }
            System.out.println(dp[i]);
        }
        return max;
    }
}

class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i = n - 1 ; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

public class demo {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        l.add(new ArrayList<>(list));
        l.add(new ArrayList<>(list));
        System.out.println(l.size());
        System.out.println(l.get(l.size()-1).size());
        Solution2 s = new Solution2();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
