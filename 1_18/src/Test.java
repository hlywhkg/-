import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/18 8:52
 * @Version 1.0
 */
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
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
public class Test {
    /*int count = 0;
    int size(TreeNode root){//节点个数
    //普通遍历
        if(root==null){
            return 0;
        }
        count++;
        count += size(root.left);
        count +=size(root.right);
        return count;
    }*/
//子路递归
    /*int size(TreeNode root){
        if(root==null){
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }*/

    /*int count = 0;

    int getLeafNodeCount(TreeNode root) {//叶子节点个数
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            count++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return count;
    }

    int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.right);
    }

    int getKLevelNodeCount(TreeNode root, int k) {//第k层节点个数
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    int getHeight(TreeNode root) {//深度
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    TreeNode find(TreeNode root, int val) {//查找是否有val的值
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    boolean isCompleteTree(TreeNode root) {//是否是完全二叉树
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode ret = queue.poll();
            if (ret != null) {
                queue.offer(ret.left);
                queue.offer(ret.right);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode top = queue.peek();
            if(top!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }*/
}
