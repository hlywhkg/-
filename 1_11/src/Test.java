import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/11 21:00
 * @Version 1.0
 */
class Solution {
    //给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
    //A -> 1
    //B -> 2
    //C -> 3
    //...
    //Z -> 26
    //AA -> 27
    //AB -> 28
    //...
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/excel-sheet-column-title
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String convertToTitle(int columnNumber) {
        //26进制
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0){
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
class Solution2 {
    //给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
    //
    //函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
    //
    //你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] twoSum(int[] numbers, int target) {
        //强迫症，想简洁点
        //哈希表查找是否有包含相加等于target的，没有则加入哈希表中，有直接返回
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                return new int[]{Math.min(i+1,map.get(target-numbers[i])),Math.max(i+1,map.get(target-numbers[i]))};
            }else {
                map.put(numbers[i],i+1);
            }
        }
        return null;
        //Map<Integer,Integer> map = new HashMap<>();
        //        for (int i = 0; i < numbers.length; i++) {
        //            if(map.containsKey(target-numbers[i])){
        //                int []arr = new int[]{i+1,map.get(target-numbers[i])};
        //                Arrays.sort(arr);
        //                return arr;
        //            }else {
        //                map.put(numbers[i],i+1);
        //            }
        //        }
        //        return null;
    }
}
class Solution1 {
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //
    //说明：
    //
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/single-number
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int singleNumber(int[] nums) {
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key ^= nums[i];
        }
        return key;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(2^2);
    }
}
