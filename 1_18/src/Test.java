import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/18 8:52
 * @Version 1.0
 */

public class Test {
    /*int count = 0;
    int size(TreeNode root){//节点个数
    //普通遍历
        if(root==null){
            return 0;
        }
        count++;
        count += size(root.left);
        count +=size(root.right);
        return count;
    }*/
//子路递归
    /*int size(TreeNode root){
        if(root==null){
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }*/

    /*int count = 0;

    int getLeafNodeCount(TreeNode root) {//叶子节点个数
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            count++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return count;
    }

    int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.right);
    }

    int getKLevelNodeCount(TreeNode root, int k) {//第k层节点个数
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    int getHeight(TreeNode root) {//深度
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    TreeNode find(TreeNode root, int val) {//查找是否有val的值
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    boolean isCompleteTree(TreeNode root) {//是否是完全二叉树
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode ret = queue.poll();
            if (ret != null) {
                queue.offer(ret.left);
                queue.offer(ret.right);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode top = queue.peek();
            if(top!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }*/
}
