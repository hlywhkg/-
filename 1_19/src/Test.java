import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/19 9:15
 * @Version 1.0
 */
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


