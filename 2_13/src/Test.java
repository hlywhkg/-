/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/13 15:20
 * @Version 1.0
 */
import javax.swing.tree.TreeNode;
import java.util.ArrayList;

class BTNode {
    int val = 0;
    BTNode left = null;
    BTNode right = null;

    public BTNode(int val) {
        this.val = val;
    }

}

class Solution2 {
    // 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
    //1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
    //2.叶子节点是指没有子节点的节点
    //3.路径只能从父节点到子节点，不能从子节点到父节点
    //4.总节点数目为n
    //
    //如二叉树root为{10,5,12,4,7},expectNumber为22
    //则合法路径有[[10,5,7],[10,12]]
    public void BFS(BTNode root, int expectNumber, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list){
        if(root == null)return;
        int ret = root.val;
        list.add(ret);
        expectNumber -= ret;
        if(root.left == null && root.right == null && expectNumber == 0){
            result.add(new ArrayList<>(new ArrayList<>(list)));
        }

        BFS(root.left,expectNumber,result,list);
        BFS(root.right,expectNumber,result,list);

        list.remove(list.size()-1);
    }
    public ArrayList<ArrayList<Integer>> FindPath(BTNode root,int expectNumber) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>list = new ArrayList<>();
        if(root == null)return result;
        BFS(root,expectNumber,result,list);
        return result;
    }
}
class Solution1 {
    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。假设输入的数组的任意两个数字都互不相同。
    //
    //数据范围： 节点数量 0≤n≤10000 \le n \le 10000≤n≤1000 ，节点上的值满足 1≤val≤1051 \le val \le 10^{5}1≤val≤105 ，保证节点上的值各不相同
    //要求：空间复杂度 O(n)O(n)O(n) ，时间时间复杂度 O(n2)O(n^2)O(n2)
    //提示：
    //1.二叉搜索树是指父亲节点大于左子树中的全部节点，但是小于右子树中的全部节点的树。
    //2.该题我们约定空树不是二叉搜索树
    //3.后序遍历是指按照 “左子树-右子树-根节点” 的顺序遍历
    //4.参考下面的二叉搜索树，示例 1
    //https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?
    public boolean VerifySquenceOfBSTHelper(int []sequence,int start,int end){
        if(start >= end){
            return true;
        }
        int i = start;
        int root = sequence[end];
        while(i < end && sequence[i] < root){
            i++;
        }

        //已经划分好了左右区间
        for(int j = i; j < end;j++){
            if(sequence[j] < root){
                return false;
            }
        }

        return VerifySquenceOfBSTHelper(sequence,start,i-1) && VerifySquenceOfBSTHelper(sequence,i,end - 1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBSTHelper(sequence,0,sequence.length - 1);
    }
}
public class Test {
    public static void main2(String[] args) {
        /*System.out.println("==========result变化==========");
            list.remove(list.size()-1);
            System.out.println(result);*/
    }
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        ArrayList<ArrayList<Integer>>result = new ArrayList<>();
        result.add(list);
        for(int i = 0; i < 5; i++){
            list.add(i);
            System.out.println("待选结果"+list);
            System.out.println("结果集:"+result);
            list.remove(list.size()-1);
            System.out.println("result变化"+result);
            System.out.println("========================");
        }
    }
}
