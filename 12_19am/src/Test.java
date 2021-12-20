import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/19 8:11
 * @Version 1.0
 */
class Solution1 {
    //在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
    //
    //如果小镇的法官真的存在，那么：
    //
    //    小镇的法官不相信任何人。
    //    每个人（除了小镇法官外）都信任小镇的法官。
    //    只有一个人同时满足条件 1 和条件 2 。
    //
    //给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
    //
    //如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-the-town-judge
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int findJudge(int n, int[][] trust) {//法官不信任任何人包括自己，
        if(n == 1)return 1;                     //所以法官入度为n-1
        int []arr = new int[n+1];               //出度为0
        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][0]]--;//当一个人信任别人时，我们对它的编号--，防止之后与法官相同
            arr[trust[i][1]]++;//当一个人被信任时，我们对它的编号++
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n-1){//入度出度相加为n-1的就是法官
                return i;
            }
        }
        return -1;
    }
}
class Solution2 {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {//暴力解法
        int s1 = strs.length;
        String str1 = strs[0];
        for (int i = 1; i < s1; i++) {
            String str2 = strs[i];
            int min = Math.min(str1.length() , str2.length());
            int index = 0;
            while(min > 0){
                if(str1.charAt(index) == str2.charAt(index)) {
                    index++;
                    min--;
                }else {
                    break;
                }
            }
            str1 = str1.substring(0,index);
        }
        return str1;
    }
}
class Solution3 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/valid-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();//用栈进行判断
        for(char c : s.toCharArray()){         //如果c是左括号，则插入一个右括号
            if(c == '(')stack.push(')'); //如果c是右括号，则判断栈中是否有与其匹配的，若没有，则说明括号匹配错误
            else if(c == '{')stack.push('}');//如果栈已经空了，而c还有字符则也说明括号匹配错误
            else if(c == '[')stack.push(']');
            else if(stack.isEmpty() || c !=stack.pop())return false;
        }
        return stack.isEmpty();
    }
}
class Solution4 {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer>hashtable = new Hashtable<Integer,Integer>();
        int i = 0;
        int k = 0;
        while(i < nums.length) {
            if(!hashtable.containsValue(nums[i])) {
                hashtable.put(k, nums[i]);
                k++;
            }
            i++;
        }
        int j = 0;
        int size = hashtable.size();
        while(size > 0) {
            nums[j] = hashtable.get(j);
            j++;
            size--;
        }
         return j;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int []arr = {1,1,2};
        int a = solution4.removeDuplicates(arr);
        System.out.println(a);
        /*Map<Integer,Integer>hashtable = new Hashtable<Integer,Integer>();
        hashtable.put(1,6);
        hashtable.put(2,7);
        System.out.println(hashtable.get(1));
        System.out.println(hashtable.get(2));*/

    }
}