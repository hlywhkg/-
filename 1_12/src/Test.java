/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/12 10:03
 * @Version 1.0
 */
class Solution3 {
    //给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
    //例如，
    //    A -> 1
    //    B -> 2
    //    C -> 3
    //    ...
    //    Z -> 26
    //    AA -> 27
    //    AB -> 28
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/excel-sheet-column-number
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int titleToNumber(String columnTitle) {
        //没啥好说的
        int sum = 0;
        double j = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            sum += (columnTitle.charAt(i) - 'A'+1) * Math.pow(26,j);
            j++;
        }
        return sum;
    }
}

class Solution2 {
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/majority-element
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int majorityElement(int[] nums) {
        //找最多
        int ret = nums[0];
        int count = 1;
        for(int num : nums) {
            if(num != ret) {
                count--;
                if(count == 0) {
                    count = 1;
                    ret = num;
                }
            }
            else
                count++;
        }
        return ret;
    }
}
class Solution1 {
    //给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
    //
    //如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
    //
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean increasingTriplet(int[] nums) {
        //a始终为数组中最小的，b为数组中第二大的
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < a){
                a = nums[i];
            }else if(nums[i] < b){
                b = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.pow(1,13));
        Solution3 solution3 = new Solution3();
        solution3.titleToNumber("AB");
    }
}
