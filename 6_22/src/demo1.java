import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/22 21:43
 * @Version 1.0
 */

class BTNode {
    int val;
    BTNode left;
    BTNode right;

    BTNode() {
    }

    BTNode(int val) {
        this.val = val;
    }

    BTNode(int val, BTNode left, BTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max,ret;
    void dfs(BTNode root,int depth){
        if(root == null)return;
        if(depth > max){
            max = depth;ret = root.val;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
    public int findBottomLeftValue(BTNode root) {
        dfs(root,1);
        return ret;
    }
}

public class demo1 {
}
