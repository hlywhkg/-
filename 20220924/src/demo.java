import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/24 10:32
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

class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (BTNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        if (p <= root.val && q >= root.val || p >= root.val && q <= root.val) {
            return root.val;
        } else if (p <= root.val && q <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p > root.val && q > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return -1;
    }
}

class Solution2 {
    public boolean IsBalanced_Solution(BTNode root) {
        if(root == null){
            return true;
        }else{
            return height(root) > 0;
        }

    }
    public int height(BTNode root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        if(leftH < 0 || rightH < 0 || Math.abs(leftH - rightH) > 1){
            return -1;
        }else{
            return Math.max(leftH,rightH)+1;
        }
    }
}

class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (BTNode root) {
        // write code here
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        boolean tag = false;
        while(!q.isEmpty()){
            BTNode cur = q.poll();
            if(cur == null){
                tag = true;
                continue;
            }
            if(tag){
                return false;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }
}

public class demo {
}
