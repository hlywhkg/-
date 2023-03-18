/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/3/18 15:46
 * @Version 1.0
 */

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

class Solution1 {
    public boolean Find(int target, int [][] array) {
        int x = array.length, y = array[0].length;
        for (int i = x - 1, j = 0; i >= 0 && j < y ;) {
            if (target > array[i][j]) {
                j++;
            } else if (target == array[i][j]) {
                return true;
            } else {
                i--;
            }
        }
        return false;
    }
}


public class test {

}
