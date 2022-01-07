import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/7 11:08
 * @Version 1.0
 */

class Solution4 {
    //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //
    //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //
    //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxProfit(int[] prices) {
        int price = 0,sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(sum < 0){
                sum = 0;
            }
            sum += prices[i] - prices[i-1];
            price = Math.max(sum,price);
        }
        return price;
    }
}
class Solution3 {
    //给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
    //
    //在「杨辉三角」中，每个数是它左上方和右上方的数的和。
    //示例 1:
    //
    //输入: rowIndex = 3
    //输出: [1,3,3,1]
    //
    //示例 2:
    //
    //输入: rowIndex = 0
    //输出: [1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/pascals-triangle-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<Integer> getRow(int rowIndex) {
        //一种解法做两道题
        List<List<Integer>>list1 = new ArrayList<>();
        int [][]arr = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer>list2 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i || i==0){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
                list2.add(arr[i][j]);
            }
            list1.add(list2);
        }
        return list1.get(rowIndex);
    }
}
class Solution2 {
    //给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
    //
    //在「杨辉三角」中，每个数是它左上方和右上方的数的和。
    //示例 1:
    //
    //输入: numRows = 5
    //输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/pascals-triangle
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<List<Integer>> generate(int numRows) {//一个二维数组接收，
        List<List<Integer>>list1 = new ArrayList<>();
        int [][]arr = new int[numRows][numRows];
        for (int i = 0; i <= numRows; i++) {
            List<Integer>list2 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i || i==0){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
                list2.add(arr[i][j]);
            }
            list1.add(list2);
        }
        return list1;
    }
}
class Solution1 {
    //如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
    //
    //    字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
    //    字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
    //    字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
    //
    //类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
    //
    //    depth("") = 0
    //    depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
    //    depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
    //    depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
    //
    //例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
    //
    //给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxDepth(String s) {
        int ans = 0,size = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                size++;
            }else if(s.charAt(i) == ')'){
                size--;
            }
            ans = Math.max(ans,size);
        }
        return ans;
    }
}
public class Test {
}
