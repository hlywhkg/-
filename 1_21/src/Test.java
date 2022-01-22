import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/21 9:34
 * @Version 1.0
 */
class BtNode {
    int val;
    BtNode left;
    BtNode right;
    BtNode(int x) { val = x; }
}

class Solution5 {
    //给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
    //
    //每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
    //
    //示例 1:
    //
    //输入:
    //
    //           1
    //         /   \
    //        3     2
    //       / \     \
    //      5   3     9
    //
    //输出: 4
    //解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
    //
    //示例 2:
    //
    //输入:
    //
    //          1
    //         /
    //        3
    //       / \
    //      5   3
    //
    //输出: 2
    //解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
    //
    //示例 3:
    //
    //输入:
    //
    //          1
    //         / \
    //        3   2
    //       /
    //      5
    //
    //输出: 2
    //解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
    //
    //示例 4:
    //
    //输入:
    //
    //          1
    //         / \
    //        3   2
    //       /     \
    //      5       9
    //     /         \
    //    6           7
    //输出: 8
    //解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int widthOfBinaryTree(BtNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 0;
        LinkedList<BtNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 1;//记录每个节点的下标存入val中，下标从1开始
        while(! queue.isEmpty()){
            //得到队列中有多少个元素
            int size = queue.size();
            //得到每一层的宽度
            int width = queue.getLast().val - queue.getFirst().val + 1;
            while(size != 0){
                BtNode top = queue.poll();
                //左子树的节点
                if(top.left != null){
                    queue.offer(top.left);
                    top.left.val = 2 *top.val;
                }
                //右子树的节点
                if(top.right != null){
                    queue.offer(top.right);
                    top.right.val = 2 *top.val + 1;
                }
                size--;
            }
            if(width > maxWidth){
                maxWidth = width;
            }
        }
        return maxWidth;
    }
}
class Solution4 {
    //你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //
    //空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    //
    //示例 1:
    //
    //输入: 二叉树: [1,2,3,4]
    //       1
    //     /   \
    //    2     3
    //   /
    //  4
    //
    //输出: "1(2(4))(3)"
    //
    //解释: 原本将是“1(2(4)())(3())”，
    //在你省略所有不必要的空括号对之后，
    //它将是“1(2(4))(3)”。
    //
    //示例 2:
    //
    //输入: 二叉树: [1,2,3,null,4]
    //       1
    //     /   \
    //    2     3
    //     \
    //      4
    //
    //输出: "1(2()(4))(3)"
    //
    //解释: 和第一个示例相似，
    //除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void treeToString(BtNode root,StringBuilder sb){
        sb.append(root.val);
        if(root.left != null){
            sb.append("(");
            treeToString(root.left,sb);
            sb.append(")");
        }else{
            if(root.right == null){
                return;
            }else{
                sb.append("()");
            }
        }
        if(root.right != null){
            sb.append("(");
            treeToString(root.right,sb);
            sb.append(")");
        }else{
            return;
        }
    }
    public String tree2str(BtNode root) {
        if(root == null)return null;
        StringBuilder sb = new StringBuilder();
        treeToString(root,sb);
        return sb.toString();
    }
}
class Solution3 {
    //给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
    //
    //
    //
    //示例 1:
    //
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    //
    //示例 2:
    //
    //Input: preorder = [-1], inorder = [-1]
    //Output: [-1]
    int preIndex = 0;
    public BtNode createTreeByPandI(int[] preorder,int[] inorder,int inbegin,int inend){
        if(inbegin > inend){
            //大于左右子树则为空
            return null;
        }
        BtNode root = new BtNode(preorder[preIndex]);
        int index = findIndexOfI(inorder,inbegin,inend,root.val);
        if(index == -1){
            return null;
        }
        preIndex++;
        root.left = createTreeByPandI(preorder,inorder,inbegin,index-1);
        root.right = createTreeByPandI(preorder,inorder,index+1,inend);
        return root;
    }
    private int findIndexOfI(int []arr,int left,int right,int key){
        //查找新创建的这个节点在中序中的位置
        for(int i = left;i <= right;i++){
            if(arr[i] == key)return i;
        }
        return -1;
    }
    public BtNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)return null;
        BtNode root = createTreeByPandI(preorder,inorder,0,preorder.length-1);
        return root;
    }
}
class Solution2 {
    //描述
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
    //
    //
    //数据范围：输入二叉树的节点数 0≤n≤10000 \le n \le 10000≤n≤1000，二叉树中每个节点的值 0≤val≤10000\le val \le 10000≤val≤1000
    //要求：空间复杂度O(1)O(1)O(1)（即在原树上操作），时间复杂度 O(n)O(n)O(n)
    //
    //注意:
    //1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
    //2.返回链表中的第一个节点的指针
    //3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
    //4.你不用输出双向链表，程序会根据你的返回值自动打印输出
    //输入描述：
    //二叉树的根节点
    //返回值描述：
    //双向链表的其中一个头节点。
    //示例1
    //输入：
    //
    //{10,6,14,4,8,12,16}
    //
    //返回值：
    //
    //From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
    //
    //说明：
    //
    //输入题面图中二叉树，输出的时候将双向链表的头节点返回即可。
    //
    //示例2
    //输入：
    //
    //{5,4,#,3,#,2,#,1}
    //
    //返回值：
    //
    //From left to right are:1,2,3,4,5;From right to left are:5,4,3,2,1;
    //
    //说明：
    //
    //                    5
    //                  /
    //                4
    //              /
    //            3
    //          /
    //        2
    //      /
    //    1
    //树的形状如上图
    BtNode prev = null;
    //二叉搜索树中序遍历即使排序的
    //二叉搜索树的根节点val大于左孩子val大于右孩子val
    public void inOrder(BtNode root){
        //打印时顺便修改指向
        if(root == null)return;
        inOrder(root.left);
        root.left = prev;
        if(prev != null){
            prev.right = root;
        }
        prev = root;
        inOrder(root.right);
    }
    public BtNode Convert(BtNode pRootOfTree) {
        if(pRootOfTree == null)return null;
        inOrder(pRootOfTree);
        BtNode head = pRootOfTree;
        while(head.left != null){
            head = head.left;
        }
        return head;
    }
}
class Solution1 {
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //
    //
    //
    //示例 1：
    //
    //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    //输出：3
    //解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    //
    //示例 2：
    //
    //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    //输出：5
    //解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
    //
    //示例 3：
    //
    //输入：root = [1,2], p = 1, q = 2
    //输出：1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    /**
     * 寻找根节点到p、q的路径
     * @param root 根节点
     * @param node 指定的节点
     * @param stack 存储根节点到指定节点的路径
     * @return 递归返回，main函数里没有用到
     */
    public boolean getPath(BtNode root, BtNode node, Stack<BtNode>stack){
        if(root == null)return false;
        stack.push(root);
        if(root == node)return true;
        boolean flg = getPath(root.left,node,stack);
        if(flg == true) return true;
        flg = getPath(root.right,node,stack);
        if(flg == true)return true;
        stack.pop();
        return false;
    }
    public BtNode lowestCommonAncestor(BtNode root, BtNode p, BtNode q) {
        //①常规递归思路
        /*if(root == null)return null;
        if(root == p || root == q)return root;
        BtNode left = lowestCommonAncestor(root.left,p,q);
        BtNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }*/
        //②栈存储轨迹
        Stack<BtNode>stack1 = new Stack<>();
        Stack<BtNode>stack2 = new Stack<>();
        getPath(root,p,stack1);
        getPath(root,q,stack2);
        int size1 = stack1.size();
        int size2 = stack2.size();
        if(size1 > size2){
            int size = size1 - size2;
            while(size != 0){
                stack1.pop();
                size--;
            }
            while(!stack1.isEmpty()){
                BtNode cur = stack1.pop();
                if(cur == stack2.pop()){
                    return cur;
                }
            }
        }else{
            int size = size2 - size1;
            while(size != 0){
                stack2.pop();
                size--;
            }
            while(!stack2.isEmpty()){
                BtNode cur = stack2.pop();
                if(cur == stack1.pop()){
                    return cur;
                }
            }
        }
        return null;
    }
}
public class Test {
    public static void main(String[] args) {
        Stack<Integer>stack1 = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();
        stack1.add(1024);
        stack2.add(1024);
        System.out.println(stack1.pop() == stack2.peek());
        Queue<Integer>queue = new ArrayDeque<>();

    }
}
