import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/4 18:44
 * @Version 1.0
 */

class Solution3 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        int prev = 0,last = prev + size - 1;
        if(size == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = last ; i < num.length ; i++) {
            list.add(find(num,prev++,i));
        }
        return list;
    }
    public int find(int[]num,int begin,int end){
        int max = 0;
        for(int i = begin; i <= end; i++) {
            if(num[i] > max){
                max = num[i];
            }
        }
        return max;
    }
}

class Solution2 {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */

    public boolean isValid (String s) {
        // write code here
        Stack<Character> s1 = new Stack<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++) {
            if(s.charAt(i) == '('){
                s1.push(')');
            }else if(s.charAt(i) == '['){
                s1.push(']');
            }else if(s.charAt(i) == '{'){
                s1.push('}');
            }else{
                if(s1.isEmpty() || s.charAt(i) != s1.pop()){
                    return false;
                }
            }
        }
        return s1.isEmpty();
    }
}

class Solution1 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty() || s2.peek() >= node){
            s2.push(node);
        }
    }

    public void pop() {
        int target = s1.pop();
        if(target == s2.peek()){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.pop();
    }
}


public class demo1 {
}
