/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/18 10:56
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


class Solution3 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //方法①
        /*if (triangle.isEmpty())
            return 0;
        ArrayList<ArrayList<Integer>> minPathSum = new ArrayList<>();
        //每一行重新new一个集合
        for (int i = 0; i < triangle.size(); ++i) {
            minPathSum.add(new ArrayList<>());
        }
        minPathSum.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); ++i) {
            int curSum = 0;
            for (int j = 0; j <= i; ++j) {
                // 处理左边界和右边界
                if (j == 0) {
                    curSum = minPathSum.get(i - 1).get(0);
                } else if (j == i) {
                    curSum = minPathSum.get(i - 1).get(j - 1);
                } else {
                    curSum = Math.min(minPathSum.get(i - 1).get(j),
                            minPathSum.get(i - 1).get(j - 1));
                }
                minPathSum.get(i).add(triangle.get(i).get(j) + curSum);
            }
        }
        int size = triangle.size();
        int min = minPathSum.get(size-1).get(0);
        for(int i = 1 ; i < size ; i++){
            min = Math.min(min,minPathSum.get(size-1).get(i));
        }
        return min;*/

        //方法②
        /*int size = triangle.size(); //定义行
        if(triangle.isEmpty() || size == 0){
            return 0;
        }
        int [][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1 ; i < size ; i++){
            int sum = 0;
            for(int j = 0 ; j <= i ; j++){
                //累计往下加
                if(j == 0){
                    //最左边一行的情况
                    sum = dp[i-1][j];
                }else if(j == i){
                    //最右边一行的情况
                    sum = dp[i-1][j-1];
                }else{
                    //非边界，即0<j<i
                    sum = Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                dp[i][j] = triangle.get(i).get(j) + sum;
            }
        }
        //到这一步已经累计到最后一行了，最后一行所有元素中找最小的即可
        int minsum = dp[size-1][0];
        for(int j = 1 ; j < size ; j++){
            minsum = Math.min(minsum,dp[size-1][j]);
        }

        return minsum;*/

        //方法③
        if (triangle.isEmpty())
            return 0;
        ArrayList<ArrayList<Integer>> minPathSum = new ArrayList<>(triangle);
        int size = minPathSum.size();
        for(int  i = size - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                int curSum = Math.min(triangle.get(i + 1).get(j),triangle.get(i + 1).get(j + 1))
                        + triangle.get(i).get(j);
                minPathSum.get(i).set(j, curSum);
            }
        }
        return minPathSum.get(0).get(0);
    }
}

class Solution2 {
    //拆分字符串
    public boolean wordBreak(String s, Set<String> dict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        //dp[i] 代表前i个字符是否能被分割，因此i要可以等于字符串的长度
        for(int i = 1 ; i <= s.length() ; i++ ){
            //进入条件首先是 j < i，不能等于，等于意味着你已经知道了dp[i]的结果
            for(int j = 0 ; j < i ; j++){
                //要求的是dp[j] && contains([j+1,i])
                //因为substring函数是前闭后开[j,i)，所以第 j 个下标对应的是 j+1 , i-1下标对应i
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    //只要满足即为true，不关心它是怎么分割的
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
class Solution1 {
    //斐波那契数列
    public int Fibonacci(int n) {
        int first = 1;
        int second = 1;
        int third = 1;
        for(int i = 3 ; i <= n ; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
public class Test {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str.substring(0, 1));
    }
}
