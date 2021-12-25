import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/25 9:05
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    //如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
    //
    //    二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
    //    偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
    //    奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
    //
    //给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/even-odd-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int size = 0;//记录该层共有多少节点
        int high = 0;//层数
        while(!queue.isEmpty()){
            size = queue.size();
            int flag = high % 2 == 0 ? 0 : 1;
            int prev = high % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;//每层第一个节点要判断是否超出节点值最大或最小
            while(size-->0) {
                TreeNode node = queue.poll();
                if(flag == 0) {
                    if(node.val % 2 == flag || node.val < prev) return false;
                }
                if(flag == 1) {
                    if(node.val % 2 == flag || node.val > prev) return false;
                }
                prev = node.val;
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            high++;
        }
        return true;
    }
}
public class Test {

}
