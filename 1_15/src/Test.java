import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/15 10:21
 * @Version 1.0
 */
import java.util.ArrayList;
class MinStack {
    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //    push(x) —— 将元素 x 推入栈中。
    //    pop() —— 删除栈顶的元素。
    //    top() —— 获取栈顶元素。
    //    getMin() —— 检索栈中的最小元素。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/min-stack
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    Stack<Integer>stack ;
    Stack<Integer>minStake;
    public MinStack() {
        stack = new Stack<>();
        minStake = new Stack<>();
    }

    public void push(int val) {
        if(!minStake.isEmpty() && minStake.peek() >= val){
            minStake.push(val);
        }else if(minStake.isEmpty()){
            minStake.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int sq = stack.pop();
        if(!minStake.isEmpty() && sq == minStake.peek()){
            minStake.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStake.peek();
    }
}
class Solution3 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //    左括号必须用相同类型的右括号闭合。
    //    左括号必须以正确的顺序闭合。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/valid-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(')stack.push(')');
            else if(c == '{')stack.push('}');
            else if(c == '[')stack.push(']');
            else if(stack.isEmpty() || c !=stack.pop())return false;
        }
        return stack.isEmpty();
    }
}
class Solution2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer>stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
           stack.push(pushA[i]);
           while(j < popA.length && !stack.isEmpty() && stack.peek() == popA[j]){
               stack.pop();
               j++;
           }
        }
        return stack.isEmpty();
    }
}
class Solution1 {
    //根据 逆波兰表示法，求表达式的值。
    //
    //有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    //
    //
    //
    //说明：
    //
    //    整数除法只保留整数部分。
    //    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String val = tokens[i];
            if(!isOperation(val)){
                stack.push(Integer.parseInt(val));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (val){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.peek();
    }
    private boolean isOperation(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }else{
            return false;
        }
    }
}
public class Test {
}
