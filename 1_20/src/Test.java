import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/20 9:47
 * @Version 1.0
 */
class BtNode {
    int val;
    BtNode left;
    BtNode right;

    BtNode() {
    }

    BtNode(int val) {
        this.val = val;
    }

    BtNode(int val, BtNode left, BtNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution4 {
    //给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [1,null,2,3]
    //输出：[1,3,2]
    //
    //示例 2：
    //
    //输入：root = []
    //输出：[]
    //
    //示例 3：
    //
    //输入：root = [1]
    //输出：[1]
    //
    //示例 4：
    //
    //输入：root = [1,2]
    //输出：[2,1]
    //
    //示例 5：
    //
    //输入：root = [1,null,2]
    //输出：[1,2]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<Integer> inorderTraversal(BtNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Stack<BtNode> stack = new Stack<>();
        BtNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
class Solution3 {
    void levelOrder1(BtNode root){//层序遍历
        if(root == null)return;
        Queue<BtNode>queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BtNode ret = queue.poll();
            System.out.println(ret.val +" ");
            if(ret.left!=null) {
                queue.add(ret.left);
            }
            if(ret.right!=null) {
                queue.add(ret.right);
            }
        }
    }
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [3,9,20,null,null,15,7]
    //输出：[[3],[9,20],[15,7]]
    //
    //示例 2：
    //
    //输入：root = [1]
    //输出：[[1]]
    //
    //示例 3：
    //
    //输入：root = []
    //输出：[]
    public List<List<Integer>> levelOrder(BtNode root) {//层序遍历
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list;
        Queue<BtNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list2 = new ArrayList<>();
            while(size > 0) {
                BtNode ret = queue.poll();
                list2.add(ret.val);
                if (ret.left != null) {
                    queue.add(ret.left);
                }
                if (ret.right != null) {
                    queue.add(ret.right);
                }
                size--;
            }
            list.add(list2);
        }
        return list;
    }
}
class Solution2 {
    //给你一个二叉树的根节点 root ， 检查它是否轴对称。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [1,2,2,3,4,4,3]
    //输出：true
    //
    //示例 2：
    //
    //输入：root = [1,2,2,null,3,null,3]
    //输出：false
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/symmetric-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isSymmetricChild(BtNode leftTree,BtNode rightTree) {
        if(leftTree == null && rightTree == null)return true;
        if(leftTree == null || rightTree == null)return false;
        if(leftTree.val == rightTree.val){//左子树的左子树等于右子树的右子树，左子树的右子树等于右子树的左子树
            return isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left);
        }
        return false;
    }
    public boolean isSymmetric(BtNode root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }
}
class Solution1 {
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //
    //本题中，一棵高度平衡二叉树定义为：
    //
    //    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [3,9,20,null,null,15,7]
    //输出：true
    //
    //示例 2：
    //
    //输入：root = [1,2,2,3,3,null,null,4,4]
    //输出：false
    //
    //示例 3：
    //
    //输入：root = []
    //输出：true
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/balanced-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int high(BtNode root){
        if(root == null)return 0;
        int leftHigh = high(root.left);//二叉树是否平衡看左右子树是否平衡
        int rightHigh = high(root.right);
        if(leftHigh >= 0 && rightHigh >= 0 && Math.abs(leftHigh-rightHigh) <= 1){//返回左右子树差值加1
            return Math.max(leftHigh,rightHigh)+1;
        }else{
            return -1;
        }
    }
    public boolean isBalanced(BtNode root) {
        if(root == null)return true;
        return high(root) >= 1;
    }
}
public class Test {
}
