import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/3 10:02
 * @Version 1.0
 */



class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        return creat(pre, vin, 0, pre.length - 1);
    }
    public int find(int[] pre, int b, int e, int key) {
        for (int i = b ; i <= e ; i++) {
            if (pre[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public int preindex = 0;
    public TreeNode creat(int[] pre, int[] vin, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int x = pre[preindex];
        TreeNode root = new TreeNode(x);
        int index = find(vin, begin, end, pre[preindex]);
        if (index == -1) {
            return null;
        }
        preindex++;
        root.left = creat(pre, vin, begin, index - 1);
        root.right = creat(pre, vin, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        TreeNode ret = root;

    }
}
