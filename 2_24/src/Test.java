/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/24 14:46
 * @Version 1.0
 */
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            //判断是否能到达当前位置
            if(max >= i){
                //能到达继续更新所能到达最远距离
                max = Math.max(max,i + nums[i]);
                //判断是否能到达最后一个位置
                if(max > nums.length - 1){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
class Solution1 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'R'){
                balance++;
            }else{
                balance--;
            }
            if(balance == 0){
                count++;
            }
        }
        return count;
    }
}
public class Test {
}
