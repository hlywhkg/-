import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/24 14:19
 * @Version 1.0
 */

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2)
            return false;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            dic.put(s1.charAt(i) , dic.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            dic.put(s2.charAt(i) , dic.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (int val : dic.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}
class MinStack{
    Stack<Integer> stack1;
    Stack<Integer>stack2;
    /** initialize your data structure here. */
    MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(!stack2.isEmpty()){
            if(x <= stack2.peek()){
                stack2.push(x);
            }
        }else{
            stack2.push(x);
        }
    }

    public void pop() {
        if(!stack1.isEmpty()){
            int cur = stack1.pop();
            if(cur == stack2.peek()){
                stack2.pop();
            }
        }
    }

    public int top() {
        if(!stack1.isEmpty()){
            return stack1.peek();
        }
        return -1;
    }

    public int min() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return -1;
    }
}
public class Test {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        Map<Character,Integer> hash = new Hashtable<>();
        hash.put('a',1);
        System.out.println(hash.get(1));
        minStack.push(1);
        minStack.push(2);
        minStack.top();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.top();

        /*int x = 3;
        int y = 1;
        if(x = y){
            System.out.println("not equal ");
        }else {
            System.out.println("Equal");
        }*/
    }
}
