import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/12 14:29
 * @Version 1.0
 */
class MyQueue {
    //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    //
    //实现 MyQueue 类：
    //
    //    void push(int x) 将元素 x 推到队列的末尾
    //    int pop() 从队列的开头移除并返回元素
    //    int peek() 返回队列开头的元素
    //    boolean empty() 如果队列为空，返回 true ；否则，返回 false
    //
    //说明：
    //
    //    你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    //    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    //
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                int a = stack1.pop();
                stack2.push(a);
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while(!stack1.isEmpty()){
                int a = stack1.pop();
                stack2.push(a);
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())return true;
        else return false;
    }
}
class MyStack {
    //请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
    //
    //实现 MyStack 类：
    //
    //    void push(int x) 将元素 x 压入栈顶。
    //    int pop() 移除并返回栈顶元素。
    //    int top() 返回栈顶元素。
    //    boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
    //
    //
    //
    //注意：
    //
    //    你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
    //    你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/implement-stack-using-queues
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty())return -1;
        if(!queue1.isEmpty()){
            int size = queue1.size();
            for(int i = 0; i < size - 1; i++){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else{
            int size = queue2.size();
            for(int i = 0; i < size - 1; i++){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty())return -1;
        if(!queue1.isEmpty()){
            int size = queue1.size();
            for(int i = 0; i < size - 1; i++){
                queue2.offer(queue1.poll());
            }
            int val = queue1.poll();
            queue2.offer(val);
            return val;
        }else{
            int size = queue2.size();
            for(int i = 0; i < size - 1; i++){
                queue1.offer(queue2.poll());
            }
            int val = queue2.poll();
            queue1.offer(val);
            return val;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
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
class MinStack {
    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //    push(x) —— 将元素 x 推入栈中。
    //    pop() —— 删除栈顶的元素。
    //    top() —— 获取栈顶元素。
    //    getMin() —— 检索栈中的最小元素。
    //
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
class Solution2 {
    //nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
    //
    //给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
    //
    //对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
    //
    //返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
    //
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/next-greater-element-i
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> hasMap = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);
        return result;
    }
}
class Solution1 {
    //给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
    //
    //请使用下述操作来构建目标数组 target ：
    //
    //    Push：从 list 中读取一个新元素， 并将其推入数组中。
    //    Pop：删除数组中的最后一个元素。
    //    如果目标数组构建完成，就停止读取更多元素。
    //
    //题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
    //
    //请返回构建目标数组所用的操作序列。
    //
    //题目数据保证答案是唯一的。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<String> buildArray(int[] target, int n) {
        List<String>list = new ArrayList<>();
        int count = 0;
        for(int i = 1; i <= target[target.length-1];){
            while(i != target[count]){
                list.add("Push");
                list.add("Pop");
                i++;
            }
            list.add("Push");
            i = target[count] + 1;
            count++;
        }
        return list;
    }
}
public class Test {
}
