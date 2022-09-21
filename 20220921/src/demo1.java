import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/21 20:27
 * @Version 1.0
 */

class BtNode {
    int val = 0;
    BtNode left = null;
    BtNode right = null;
    public BtNode(int val){
        this.val = val;
    }
}
class Solution4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public BtNode Mirror (BtNode pRoot) {
        // write code here
        if(pRoot == null){
            return null;
        }
        BtNode tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tmp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
class Solution3 {
    /**
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public BtNode mergeTrees (BtNode t1, BtNode t2) {
        // write code here
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        BtNode head = new BtNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left,t2.left);
        head.right = mergeTrees(t1.right,t2.right);
        return head;
    }
}

class Solution2 {
    boolean isSymmetrical(BtNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return p(pRoot.left,pRoot.right);
    }
    boolean p(BtNode t1,BtNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 != null && t2 != null){
            return t1.val == t2.val && p(t1.left,t2.right) && p(t1.right,t2.left);
        }
        return false;
    }
}


class Solution1 {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (BtNode root, int sum) {
        // write code here
        if(root == null){
            return false;
        }
        //高级操作
        if(root.left==null && root.right==null)return root.val == sum;
        System.out.println(sum);
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
public class demo1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        BtNode head = new BtNode(1);
        head.left = new BtNode(2);
        head.right = new BtNode(3);
        head.left.right = new BtNode(5);
        System.out.println(s.hasPathSum(head, 8));
    }
}
