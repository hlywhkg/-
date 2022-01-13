/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/13 11:40
 * @Version 1.0
 */
class Solution5 {
    //句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
    //
    //    例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
    //
    //给你一个句子 s?????? 和一个整数 k?????? ，请你将 s?? 截断 ?，???使截断后的句子仅含 前 k?????? 个单词。返回 截断 s?????? 后得到的句子。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/truncate-sentence
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            if(i == k-1){
                sb.append(str[i]);
            }else{
                sb.append(str[i]+" ");
            }
        }
        return sb.toString();
    }
}
class Solution4 {

    // 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
    //
    //字符串回文指该字符串正序与其逆序逐字符一致。
    //
    //数据范围：0<n≤10000000 < n \le 10000000<n≤1000000
    //要求：空间复杂度 O(1)O(1)O(1)，时间复杂度 O(n)O(n)O(n)
    //https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=188&&tqId=38638&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        // write code here
        int left = 0,right = str.length()-1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution3 {
    // 实现函数 int sqrt(int x).
    //计算并返回 x 的平方根（向下取整）
    //
    //数据范围： 0<=x<231?10 <= x < 2^{31}-10<=x<231?1
    //要求：空间复杂度 O(1)O(1)O(1)，时间复杂度 O(logx)O(logx)O(logx)
    //牛客网：https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=188&&tqId=38559&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        if(x == 0 || x == 1)return x;
        int left = 0,right = x,s = 0;
        while(left <= right){
            int mid = (left+right)/2;
            if(x / mid > mid){
                left = mid + 1;
                s = mid;
            }else if(x / mid < mid){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return s;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution2 {
    //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-linked-list-elements
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode removeElements(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return head;
        ListNode prev=head;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return head;
    }
}
class Solution1 {
    //给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
    //
    //请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int dominantIndex(int[] nums) {
        //找最大和次大，比较最大和次大
        if(nums.length == 1)return 0;
        int max = Integer.MIN_VALUE,min = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                min = max;
                max = nums[i];
                index = i;
            }else if(nums[i] > min){
                min = nums[i];
            }
        }
        if(max / 2 >= min)return index;
        else return -1;
    }
}
public class Test {
    public static void main(String[] args) {
        /*Double x = 1.0;
        long y = 1;
        float a = x / y;*/
        /*int i = -3;
        i = ++(i++);*/
        Solution5 solution5 = new Solution5();
        solution5.truncateSentence("hello world you are right",4);
    }
}
