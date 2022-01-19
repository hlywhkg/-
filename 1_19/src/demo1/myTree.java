/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/19 22:09
 * @Version 1.0
 */
package demo1;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class myTreeNode{
    int val;
    myTreeNode left;
    myTreeNode right;
    myTreeNode(){}

    public myTreeNode(int val) {
        this.val = val;
    }

    public myTreeNode(int val, myTreeNode left, myTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class myTree {
    private myTreeNode root;

    public myTree(myTreeNode root) {
        this.root = root;
    }

    void preOrderStr(myTreeNode root){//先序遍历
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderStr(root.left);
        preOrderStr(root.right);
    }

    void inOrderTrav(myTreeNode root){//中序遍历
        if(root == null){
            return;
        }
        inOrderTrav(root.left);
        System.out.println(root.val);
        inOrderTrav(root.right);
    }

    void PostOrderTrav(myTreeNode root){//后序遍历
        if(root == null){
            return;
        }
        PostOrderTrav(root.left);
        PostOrderTrav(root.right);
        System.out.println(root.val);
    }

    int count = 0;
    int size1(myTreeNode root){//节点个数
        //普通遍历
        if(root==null){
            return 0;
        }
        count++;
        count += size1(root.left);
        count += size1(root.right);
        return count;
    }
    //子路递归
    int size(myTreeNode root){
        if(root==null){
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    int count1 = 0;

    int getLeafNodeCount(myTreeNode root) {//叶子节点个数
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            count1++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return count1;
    }

    int getLeafNodeCount1(myTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.right);
    }

    int getKLevelNodeCount(myTreeNode root, int k) {//第k层节点个数
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    int getHeight(myTreeNode root) {//深度
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    myTreeNode find(myTreeNode root, int val) {//查找是否有val的值
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        myTreeNode ret = find(root.left,root.left.val);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right,root.right.val);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    boolean isCompleteTree(myTreeNode root) {//是否是完全二 叉树
        if (root == null) return true;
        Queue<myTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            myTreeNode ret = queue.poll();
            if (ret != null) {
                queue.offer(ret.left);
                queue.offer(ret.right);
            } else {
                break;
            }
        }
        while(!queue.isEmpty()){
            myTreeNode top = queue.peek();
            if(top!=null){
                return false;
            }else{
                queue.poll();
            }
        }
        return true;
    }

    public boolean isSameTree(myTreeNode p, myTreeNode q) {
        //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
        //
        //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
        //
        //
        //
        //示例 1：
        //
        //输入：p = [1,2,3], q = [1,2,3]
        //输出：true
        //
        //示例 2：
        //
        //输入：p = [1,2], q = [1,null,2]
        //输出：false
        //
        //示例 3：
        //
        //输入：p = [1,2,1], q = [1,1,2]
        //输出：false
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/same-tree
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        if(p == null && q == null)return true;
        if(p!=null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
    //给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
    //
    //二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [3,4,5,1,2], subRoot = [4,1,2]
    //输出：true
    //
    //示例 2：
    //
    //输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    //输出：false
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/subtree-of-another-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isSameTree1(myTreeNode p, myTreeNode q) {
        if(p == null && q == null)return true;
        if(p!=null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
    public boolean isSubtree(myTreeNode root, myTreeNode subRoot) {
        if(root == null && subRoot == null)return true;
        if(root == null && subRoot != null)return false;
        return isSubtree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static void main(String[] args) {
        myTreeNode root = new myTreeNode(1);
        root.left = new myTreeNode(2);
        root.right = new myTreeNode(3);
        myTreeNode r1 = root.left;
        r1.left = new myTreeNode(4);
        r1.right = new myTreeNode(5);

        myTree myTree = new myTree(root);
        myTree.preOrderStr(root);
        System.out.println("=========================");
        myTree.inOrderTrav(root);
        System.out.println("=========================");
        myTree.PostOrderTrav(root);
    }
}
