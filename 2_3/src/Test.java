/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/3 10:17
 * @Version 1.0
 */
import java.util.Map;
import java.util.HashMap;
class Solution3 {
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    //
    //示例 1:
    //
    //输入：s = "abaccdeff"
    //输出：'b'
    //
    //示例 2:
    //
    //输入：s = ""
    //输出：' '
    //
    //
    public char firstUniqChar(String s) {
        Map<Character,Boolean>map = new HashMap<>();
        char c[] = s.toCharArray();
        for(char ch : c ){
            map.put(ch,!map.containsKey(ch));
        }
        for(char ch : c){
            if(map.get(ch)){
                return ch;
            }
        }
        return ' ';
    }
}
class Solution2 {
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //
    //给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
    //
    //示例 1：
    //
    //输入：[3,4,5,1,2]
    //输出：1
    //
    //示例 2：
    //
    //输入：[2,2,2,0,1]
    //输出：0
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[right] > numbers[mid]){
                right = mid;
            }else if(numbers[right] < numbers[mid]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return numbers[right];
    }
}
class Solution1 {
    //在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //
    //
    //
    //示例:
    //
    //现有矩阵 matrix 如下：
    //
    //[
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0 ){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
public class Test {
    public static void main(String[] args) {
        String s = " fjahskgvaljbakl";
        char c[] = s.toCharArray();
    }
}
