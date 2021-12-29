/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/29 20:52
 * @Version 1.0
 */

class Solution {
    public int countQuadruplets(int[] nums) {
        //给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
        //
        //    nums[a] + nums[b] + nums[c] == nums[d] ，且
        //    a < b < c < d
        //
        //
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/count-special-quadruplets
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        //暴力枚举
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        if(nums[i]+nums[j]+nums[k] == nums[l]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }
}
public class Test {

}
