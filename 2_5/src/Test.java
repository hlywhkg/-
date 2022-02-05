/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/5 15:00
 * @Version 1.0
 */
class Solution4 {
    //在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    //
    //
    //
    //示例 1:
    //
    //输入:
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //输出: 12
    //解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
    public int maxValue(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];//第i行j列最大利润
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i = 1;i < grid[0].length; i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i = 1;i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
class Solution3 {
    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    //
    //
    //
    //示例 1:
    //
    //输入: [7,1,5,3,6,4]
    //输出: 5
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxProfit(int[] prices) {
        int j = Integer.MAX_VALUE;
        if(prices.length == 0 || prices.length == 1)return 0;
        int dp[] = new int[prices.length];//dp[n]表示第n天的最大利润
        int min = prices[0];
        int max = 0;
        dp[0] = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min,prices[i-1]);
            dp[i] =Math.max( prices[i] - min , dp[i-1] );
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
class Solution2 {
    //青蛙跳台阶
    public int numWays(int n) {
        if(n == 0)return 1;
        if(n == 1)return 1;
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            if(dp[i] > 1000000007){
                dp[i] %= 1000000007;
            }
        }
        return dp[n];
    }
}
class Solution1 {
    //斐波那契数列
    public int numWays(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            if(dp[i] > 1000000007){
                dp[i] %= 1000000007;
            }
        }
        return dp[n];
    }
}
public class Test {
}
