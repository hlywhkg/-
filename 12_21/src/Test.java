import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/21 21:32
 * @Version 1.0
 */

class Solution1 {
    public int dayOfYear(String date) {
        //给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
        //
        //通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/day-of-the-year
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        String ret[] = date.split("-");//分解
        int year = Integer.parseInt(ret[0]);
        int month = Integer.parseInt(ret[1]);
        int day = Integer.parseInt(ret[2]);
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//每月天数
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            ++amount[1];//闰年加1
        }

        int ans = 0;
        for (int i = 0; i < month - 1; ++i) {
            ans += amount[i];//每月天数相加
        }
        return ans + day;
    }
}
class Solution2 {
    public int removeElement(int[] nums, int val) {
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        //
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/remove-element
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        if(nums == null)return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {//没什么好说的
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
public class Test {
    public static void main(String[] args) {

    }
}
