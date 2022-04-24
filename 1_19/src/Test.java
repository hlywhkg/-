import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/19 9:15
 * @Version 1.0
 */
class TreeNode1 {
     int val;
     TreeNode1 left;
     TreeNode1 right;
     TreeNode1() {}
     TreeNode1(int val) { this.val = val; }
     TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution1 {
    //给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    //
    //你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
    //
    //示例 1:
    //
    //输入:
    //	Tree 1                     Tree 2
    //          1                         2
    //         / \                       / \
    //        3   2                     1   3
    //       /                           \   \
    //      5                             4   7
    //输出:
    //合并后的树:
    //	     3
    //	    / \
    //	   4   5
    //	  / \   \
    //	 5   4   7
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-two-binary-trees
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public TreeNode1 mergeTrees(TreeNode1 root1, TreeNode1 root2) {
        if(root1 == null)return root2;
        if(root2 == null)return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
class BTNode {
      int val;
    BTNode left;
    BTNode right;
    BTNode() {}
    BTNode(int val) { this.val = val; }
    BTNode(int val, BTNode left, BTNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public boolean isSameTree(BTNode p, BTNode q) {
        if(p == null && q == null)return true;
        if(p!=null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
public class Test {
    public void levelOrder(TreeNode root) {
        /*Queue<Character>queue = new ArrayDeque<>();
        if(root == null)return;
        TreeNode cur = root;
        queue.add(cur.val);
        while(!queue.isEmpty()){
            System.out.println(queue.poll()+' ');
            if(cur.left != null) {
                queue.add(cur.left.val);
            }
            if(cur.right != null) {
                queue.add(cur.right.val);
            }
        }*/
    }
}


