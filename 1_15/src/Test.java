import java.util.Stack;
import java.util.ArrayList;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/15 10:21
 * @Version 1.0
 */
class Solution7 {
    //给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
    //
    //如果相等，返回 true ；否则，返回 false 。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/backspace-string-compare
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>stack1 = new Stack<>();
        Stack<Character>stack2 = new Stack<>();
        int s1 = s.length(),t1 = t.length();
        for (int i = 0; i < s1; i++) {
            char c = s.charAt(i);
            if(c != '#'){
                stack1.push(c);
            }else{
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        for (int i = 0; i < t1; i++) {
            char c = t.charAt(i);
            if (c != '#') {
                stack2.push(c);
            } else {
                if(!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        if(stack1.size() != stack2.size())return false;
        while(!stack1.isEmpty()){
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }
        return true;
    }
}
class Solution6 {
    //你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
    //
    //比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
    //
    //    整数 x - 表示本回合新获得分数 x
    //    "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
    //    "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
    //    "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
    //
    //请你返回记录中所有得分的总和。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/baseball-game
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    boolean isNumber(String s){
        if(!s.equals("C") && !s.equals("D") && !s.equals("+")){
            return true;
        }
        return false;
    }
    public int calPoints(String[] ops) {
        Stack<Integer>stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String str = ops[i];
            if(isNumber(str)){
                stack.push(Integer.parseInt(str));
            }else{
                switch (str){
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(stack.peek()*2);
                        break;
                    case "+":
                        int num1 = stack.pop();
                        int num2 = stack.peek();
                        stack.push(num1);
                        stack.push(num1+num2);
                        break;
                }
            }
        }
        int sum = 0;
        while(!stack.isEmpty())sum += stack.pop();
        return sum;
    }
}
class Solution5 {
    public int totalMoney(int n) {
        int week = n / 7;//总共多少周
        int day = n % 7;//最后一周还有多少天
        int sum = 0;
        int k = 1;//每周一的利息
        while(week-- > 0){
            sum +=( k + ( k + 6 ) ) * 7 / 2;//等差数列求和一周的利息
            k++;//每周利息加1
        }
        while(day-- > 0)sum += k++;//最后几天的利息
        return sum;
    }
}
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
