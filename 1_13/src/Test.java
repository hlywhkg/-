/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/13 11:40
 * @Version 1.0
 */

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
}
