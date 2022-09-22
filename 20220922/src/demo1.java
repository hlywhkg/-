import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/22 19:22
 * @Version 1.0
 */

class BtNode {
    int val = 0;
    BtNode left = null;
    BtNode right = null;
    public BtNode(int val) {
      this.val = val;
    }
 }

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    BtNode pre;
    public boolean isValidBST (BtNode root) {
        // write code here
        if(root.left != null&&!isValidBST(root.left)){
            return false;
        }
        if(pre != null && root.val < pre.val){
            return false;
        }
        pre = root;
        if(root.right != null){
            return isValidBST(root.right);
        }
        return true;
    }
}

public class demo1 {
}
