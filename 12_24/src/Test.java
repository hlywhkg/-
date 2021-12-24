import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/24 18:41
 * @Version 1.0
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        /*if(nums==null)return 0;//暴力解法
        for (int i = 0; i < nums.length; i++) {
            if(target >= nums[i])return i;
        }
        return nums.length;*/
        int left = 0;//二分解法
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return right+1;
    }
}
public class Test {
}
