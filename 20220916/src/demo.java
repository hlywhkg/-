/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/16 21:10
 * @Version 1.0
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

class Solution1 {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int leftVal = maxDepth(root.left);
        int rightVal = maxDepth(root.right);
        return 1 + (leftVal > rightVal ? leftVal : rightVal);
    }
}

public class demo {
}
