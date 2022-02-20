/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/20 10:52
 * @Version 1.0
 */

class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int num = A.length;
        if (m == 0 || num == 0)
            return 0;
        //多加一行一列，用于设置初始条件
        int[][] maxValue = new int[num + 1][m + 1];
        //初始化所有位置为0，第一行和第一列都为0，初始条件
        for (int i = 0; i <= num; ++i) {
            maxValue[i][0] = 0;
        }
        for (int i = 1; i <= m; ++i) {
            maxValue[0][i] = 0;
        }
        for (int i = 1; i <= num; ++i) {
            for (int j = 1; j <= m; ++j) {
                //第i个商品在A中对应的索引为i-1: i从1开始
                //如果第i个商品大于j,说明放不下， 所以(i,j)的最大价值和(i-1,j)相同
                if (A[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    //如果可以装下，分两种情况，装或者不装
                    //如果不装，则即为(i-1, j)
                    //如果装，需要腾出放第i个物品大小的空间：
                    //j - A[i-1],装入之后的最大价值即为(i -1, j - A[i-1]) + 第i个商品的价值V[i - 1]
                    //最后在装与不装中选出最大的价值
                    int newValue = maxValue[i - 1][j - A[i - 1]]
                            + V[i - 1];
                    maxValue[i][j] = Math.max(newValue
                            , maxValue[i - 1][j]);
                }
            }
        } //返回装入前N个商品，物品大小为m的最大价值
        return maxValue[num][m];
    }
}

class Solution2 {
    //到达( i , j )共有多少种方式
    public int uniquePaths (int m, int n) {
        // write code here
        int dp[][] = new int[m] [n];
        //初始化第一列为1
        for(int i = 0 ; i < m ; i++){
            dp[i][0] = 1;
        }
        //第一行为1
        for(int j = 0 ; j < n ; j++){
            dp[0][j] = 1;
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
class Solution1 {
    /**
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1 ; i < m ; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1 ; j < n ; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
public class Test {
    public static void main(String[] args) {

    }
}
