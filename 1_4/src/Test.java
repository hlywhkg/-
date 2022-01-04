/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/4 10:27
 * @Version 1.0
 */
class Solution4 {
    public String addBinary(String a, String b) {
        //给你两个二进制字符串，返回它们的和（用二进制表示）。
        //
        //输入为 非空 字符串且只包含数字 1 和 0。
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/add-binary
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         StringBuffer buf = new StringBuffer();
         int ans = 0;
        for (int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0 ; i--,j--) {
            int sum = ans;
            sum += i >= 0 ? a.charAt(i) - '0': 0;
            sum += j >= 0 ? b.charAt(j) - '0': 0;
            buf.append(sum %2);
            ans = sum / 2;
        }
        if(ans != 0){
            buf.append(1);
        }
        return buf.reverse().toString();//stringBuffer 不能直接强转String ,这个toString简直绝绝子
    }
}
class Solution3 {
    public int[] plusOne(int[] digits) {
        int len = digits.length ;
        for (int i = len-1; i >= 0; i--) {//这个等于很关键 可能出现 各位数的情况
            digits[i]++;//先直接加1，后续判断
            digits[i] %=10;
            if(digits[i] != 0){//如果不等于0 说明没有出现 99 这种进1 变为100 的情况
                return digits;
            }
        }
        digits = new int[len+1];// 99 + 1 = 100
        digits[0] = 1;//第一位为1 ，后续全为0.
        return digits;
    }
}

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
    public static void main(String[] args) {
        System.out.println(1%2);
    }
}
