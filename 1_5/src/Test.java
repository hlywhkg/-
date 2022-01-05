/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/5 14:30
 * @Version 1.0
 */
class Solution3 {
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //
    //注意：给定 n 是一个正整数。
    //
    //示例 1：
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/climbing-stairs
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int climbStairs(int n) {
        //动态规划
        //第一步确定dp[i]的目的
        //第二步确定dp[]初始值
        //动态规划中一定会有前后之间有关联的，我们只需找出关系即可
        int dp[] = new int[n + 1];
        //dp[i]为i层楼梯有多少种爬法
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
class Solution2 {
    public int mySqrt(int x) {
        //给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
        //
        //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
        //
        //注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
        //
        //
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/sqrtx
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        //二分法
        int left = 1,right = x;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);//防止相加溢出，右移符优先顺序低，所以要用括号括起来哦
            if (x / mid >= mid) {//防止相乘溢出
                if(x / (mid +1) < mid +1){
                    return mid;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return 0;
    }
}
class Solution1 {
    ////给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
    //        //
    //        //注意：你 不能 修改非 '?' 字符。
    //        //
    //        //题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
    //        //
    //        //在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
    //        //
    //        //来源：力扣（LeetCode）
    //        //链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
    //        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String modifyString(String s) {
        //发那会无连续重复的字符串，即相邻两个字符不相同
        char []arr = s.toCharArray();
        if(arr[0] == '?')arr[0] = 'a';//如果第一个是？我们将其转为字符'a'
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == '?'){
                arr[i] =(char) ('a' + (arr[i-1] - 'a' +1)%26);//如果第i个字符为？我们另其等于前一个字符加1，这个表达式防止小于字符a或者大于字符z
            }else{
                if(arr[i-1] == arr[i]){
                    arr[i-1] = (char) ('a' + (arr[i-1] - 'a' +1)%26);//如果第i个字符不为？，则看他是否等于前一个，因为这个不能修改嘛
                }                                                    //根据题意不会有重复字符，所以这个相等的是我们自己转的，所以可以另其再等于
            }                                                        //前一个加1.因为此时arr[i-1] = arr[i-2]+1所以再加一还是不会等于arr[i-2]的
        }
        return new String(arr);
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println('a'+'c');
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.mySqrt(8));
    }
}
