import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/7 22:18
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

class Solution2 {
    public boolean hasPathSum(BTNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
class Solution {
    public BTNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }
    public BTNode dfs (int arr[] , int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + ( right - left ) / 2;
        BTNode node = new BTNode(arr[mid]);
        node.left = dfs(arr,left,mid - 1);
        node.right = dfs(arr,mid + 1 , right);
        return node;
    }
}
public class demo1 {
}
