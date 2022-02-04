import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/4 14:16
 * @Version 1.0
 */
class BtNode {
    int val;

    public BtNode(int val, BtNode left, BtNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    BtNode left;
    BtNode right;

    BtNode(int x) {
        val = x;
    }
}

class Solution3 {
    //请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isOk(BtNode left,BtNode right){
        if(left == null && right == null)return true;
        if(left == null || right == null)return false;
        if(left.val == right.val){
            return isOk(left.left,right.right) && isOk(left.right,right.left);
        }
        return false;
    }
    public boolean isSymmetric(BtNode root) {
        if(root == null){
            return true;
        }
        return isOk(root.left,root.right);
    }
}

class Solution2 {
    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    //
    //例如输入：
    //
    //     4
    //   /   \
    //  2     7
    // / \   / \
    //1   3 6   9
    //镜像输出：
    //
    //     4
    //   /   \
    //  7     2
    // / \   / \
    //9   6 3   1
    //
    //
    //
    //示例 1：
    //
    //输入：root = [4,2,7,1,3,6,9]
    //输出：[4,7,2,9,6,3,1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public BtNode mirrorTree(BtNode root) {
        return root == null ? null : new BtNode(root.val, mirrorTree(root.right), mirrorTree(root.left));
    }
}
class Solution1 {
    //输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    //
    //B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    //
    //例如:
    //给定的树 A:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //给定的树 B：
    //
    //   4
    //  /
    // 1
    //返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0,ans = 0;
        for(int i = 0; i < rectangles.length; i++){
            int cur = Math.min(rectangles[i][0],rectangles[i][1]);
            if(maxLen == cur)ans++;
            else if(cur > maxLen){
                maxLen = cur;ans = 1;
            }
        }
        return ans;
    }
}
public class Test {
}
