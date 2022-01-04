/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/4 10:27
 * @Version 1.0
 */

class Solution2 {
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
    //
    //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/length-of-last-word
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int lengthOfLastWord(String s) {
        //额，没什么好说的
        String []str = s.split(" ");
        return str[str.length-1].length();
    }
}
class Solution1 {
    public int maxSubArray(int[] nums) {
        //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        //
        //子数组 是数组中的一个连续部分。
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/maximum-subarray
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        //动态规划
        /*int ans = nums[0];
        int sum = 0;
        for (int m: nums) {
            if(sum < 0){
                sum = m;
            }else {
                sum+=m;
            }
            ans = Math.max(sum,ans);
        }
        return ans;*/
        int len = nums.length;
        int ans = nums[0];
        int []dp = new int[len];//dp[i]表示以nums[i]结尾的连续子段的最大和
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];//如果大于0说明前面的数对这个最大和有增益效果，所以加上
            }else{
                dp[i] = nums[i];
            }
            ans = Math.max(ans,dp[i]);//小于0 ，直接另起炉灶，相当于重新找一个起点
        }
        return ans;
    }
}
public class Test {
}
