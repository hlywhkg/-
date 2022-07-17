/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/17 20:27
 * @Version 1.0
 */

class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length,ans = 0;
        for (int i = 0; i < n; i++) {
            int ret = i,count = 0;
            while(nums[ret] != -1){
                count++;
                int cur = ret;
                ret = nums[cur];
                nums[cur] = -1;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}

public class demo1 {
}
