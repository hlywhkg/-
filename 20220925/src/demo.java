/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/25 18:47
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
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return dfs(root,o1,o2).val;
    }
    public TreeNode dfs(TreeNode root,int o1,int o2){
        if(root == null || root.val == o1 || root.val == o2){
            return root;
        }
        TreeNode left = dfs(root.left,o1,o2);
        TreeNode right = dfs(root.right,o1,o2);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
public class demo {
}
