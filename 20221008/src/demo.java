import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/8 23:10
 * @Version 1.0
 */

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(')count++;
            if(count == 0 && !isS(c)){
                stack.add(c);
            }
        }
    }
    public boolean isS(char c){
        if(c == '+' || c == '-' || c == '*'){
            return true;
        }
        return false;
    }
}

public class demo {
}
