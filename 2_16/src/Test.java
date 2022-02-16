/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/16 15:33
 * @Version 1.0
 */
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BTNode {
    int val = 0;
    BTNode left = null;
    BTNode right = null;

    public BTNode(int val) {
        this.val = val;

    }
}
class Solution6{
    //给定一颗二叉搜索树，找出第k小的数
    BTNode BTNode(BTNode root, int k){
        Stack<BTNode>stack = new Stack<>();
        if(root == null || k <= 0)return null;
        BTNode node = root;
        do{
            while(node != null){
                stack.push(node.left);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                k--;
                if(k == 0){
                    return node;
                }
            }
            node = node.right;
        }while(node != null || !stack.isEmpty());
        return null;
    }
}
class Solution5 {
    // 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
    //
    //数据范围：0≤n≤15000 \le n \le 15000≤n≤1500,树上每个节点的val满足 ∣val∣<=100|val| <= 100∣val∣<=100
    //要求：空间复杂度：O(n)O(n) O(n)，时间复杂度：O(n)O(n)O(n)
    //例如：
    //给定的二叉树是{1,2,3,#,#,4,5}
    public ArrayList<ArrayList<Integer> > Print(BTNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null)return list;
        Stack<BTNode>stack = new Stack<>();//要注意一般逆序都能用到栈这种数据结构，而使用栈基本离不开队列，除非是栈的特定题
        Queue<BTNode> queue = new LinkedList<>();
        int flg = 1;//1: left->right  2: right->left
        stack.push(pRoot);
        while(!stack.isEmpty()){
            int size = stack.size();
            ArrayList<Integer>list2 = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                BTNode cur = stack.pop();
                list2.add(cur.val);
                BTNode first = (flg == 1) ? cur.left : cur.right;//最先放入的是左子树还是右子树可以通过下方flg得到改变实现
                BTNode Second = (flg == 1) ? cur.right : cur.left;//注意是每个节点的左右子树，而非一层是左再右
                if(first != null){
                    queue.offer(first);
                }
                if(Second != null){
                    queue.offer(Second);
                }
            }
            while(!queue.isEmpty()){//队列先进先出，放入中后就会逆序打印。
                stack.push(queue.poll());
            }
            list.add(new ArrayList<>(list2));
            flg = (flg == 1) ? 2 : 1;
        }
        return list;
    }
}
class Solution4 {
    //逆置一句话
    //先逆置每个单词，再逆置整句话
    public static void ReverseString(char str[],int start,int end){
        while(start < end){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return str;
        }
        char[]ch = str.toCharArray();
        int size = ch.length;
        int i = 0;
        int j = i;
        while(i < size){
            while(i < size && !Character.isSpace(ch[i]))i++;
            ReverseString(ch,j,i-1);
            while(i < size && Character.isSpace(ch[i]))i++;
            j = i;
        }
        ReverseString(ch,j,i-1);
        ReverseString(ch,0,size-1);
        return new String(ch);
    }
}
class Solution3 {
    //左旋字符串
    public static void ReverseString(char str[],int start,int end){
        while(start < end){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            return str;
        }
        char[]ch = str.toCharArray();
        n = n % str.length();
        ReverseString(ch,0,n-1);
        ReverseString(ch,n,ch.length - 1);
        ReverseString(ch,0,ch.length-1);
        return new String(ch);
    }
}
class Solution2 {
    //给定一个数，求1到这个数中有多少个连续子序列的值等于该数
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        if(sum <= 0)return list;
        int start = 1;
        int high = 2;

        while(start < high){
            int total = (start + high) * (high - start + 1) / 2;
            if(total == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = start; i <= high ; i++){
                    temp.add(i);
                }
                list.add(temp);
                start++;
            }else if(total > sum){
                start++;
            }else{
                high++;
            }
        }
        return list;
    }
}
class Solution1 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0 || num1 == null || num2 == null)return;
        int result = array[0];
        //第一次遍历找出的是两个不同的数异或的结果，这个数一定有一个比特位是1，意味着两个数
        //在这个1位置的数不同
        for(int i = 1; i < array.length ; i++){
            result ^= array[i];
        }
        if(result == 0)return;
        int ret = 1;
        int size = 32;
        //找出这个数的第一个比特位为1的位置
        //通过左移实现找出
        while(size > 0){
            if((ret & result) == 0){
                ret = ret << 1;
                size--;
            }else{
                break;
            }
        }
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0 ; i < array.length ; i++){
            //分组  一组为这个位置比特位为1，另一组这个位置比特位为0
            if((ret & array[i]) == 0){//转换为在一个两个数组中分别找一个只出现一次的数
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}
public class Test {

}
