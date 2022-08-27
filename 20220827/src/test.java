import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/27 11:16
 * @Version 1.0
 */

class BTNode {
    int val = 0;
    BTNode left = null;
    BTNode right = null;
    public BTNode(int val) {
      this.val = val;
    }
  }

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer> > Print(BTNode root) {
        Deque<BTNode> d = new ArrayDeque<>();
        d.addLast(root);
        while(!d.isEmpty()) {
            int size = d.size();
        }
    }

}

class Solution4 {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder (BTNode root) {
        // write code here
        Deque<BTNode> d = new ArrayDeque<>();
        d.addLast(root);
        dfs(d);
        return list;
    }
    public void dfs(Deque<BTNode> d) {
        while(!d.isEmpty()){
            int size = d.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            while(size-- > 0) {
                BTNode ret = d.pollFirst();
                if(ret.left != null){
                    d.addLast(ret.left);
                }
                if(ret.right != null){
                    d.addLast(ret.right);
                }
                tmp.add(ret.val);
            }
            list.add(tmp);
        }
    }
}

class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    List<Integer> list = new ArrayList<>();
    public int[] postorderTraversal (BTNode root) {
        // write code here
        postTra(root);
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public void postTra(BTNode head) {
        if(head == null){
            return;
        }
        if(head.left != null){
            postTra(head.left);
        }
        if(head.right != null){
            postTra(head.right);
        }
        list.add(head.val);
    }
}


class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    List<Integer> list = new ArrayList<>();
    public int[] inorderTraversal (BTNode root) {
        // write code here
        indTra(root);
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public void indTra(BTNode head){
        if(head == null){
            return;
        }
        if(head.left != null) {
            indTra(head.left);
        }
        list.add(head.val);
        if(head.right != null) {
            indTra(head.right);
        }
    }
}

class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    List<Integer> list = new ArrayList<>();
    public int[] preorderTraversal (BTNode root) {
        // write code here
        preTra(root);
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public void preTra(BTNode head){
        if(head == null){
            return;
        }
        list.add(head.val);
        if(head.left != null) {
            preTra(head.left);
        }
        if(head.right != null) {
            preTra(head.right);
        }
    }
}

public class test {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        BTNode head = new BTNode(1);
        head.left = new BTNode(2);
        head.right = new BTNode(3);
        head.left.left = new BTNode(4);
        s.preorderTraversal(head);

    }
}
