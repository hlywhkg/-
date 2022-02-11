import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/11 15:55
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

class Solution5 {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
    //
    //数据范围：链表长度满足 0≤n≤1000 0 \le n \le 1000 \ 0≤n≤1000  ，链表中的值满足 1≤val≤1000 1 \le val \le 1000 \ 1≤val≤1000
    //
    //进阶：空间复杂度 O(n) O(n)\ O(n)  ，时间复杂度 O(n) O(n) \ O(n)
    //
    //例如输入{1,2,3,3,4,4,5}时，对应的输出为{1,2,5}，对应的输入输出链表如下图所示：
    //示例1
    //输入：
    //
    //{1,2,3,3,4,4,5}
    //
    //返回值：
    //
    //{1,2,5}
    //
    //示例2
    //输入：
    //
    //{1,1,1,8}
    //
    //返回值：
    //
    //{8}
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val == cur.next.val){
                while(cur.next!=null&&cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
}
class Solution4 {
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //
    //
    //
    //示例 1：
    //
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //
    //示例 2：
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //
    //示例 3：
    //
    //输入：l1 = [], l2 = [0]
    //输出：[0]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newhead = new ListNode(-1);
        ListNode tmp = newhead;
        while(l1!=null && l2!= null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if(l1 != null){
            tmp.next = l1;
        }
        if(l2 != null){
            tmp.next = l2;
        }
        return newhead.next;
    }
}
class Solution3 {
    public ListNode oddEvenList(ListNode head) {
        //给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
        //
        //第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
        //
        //请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
        //
        //你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
        //
        //
        //
        //示例 1:
        //
        //输入: head = [1,2,3,4,5]
        //输出: [1,3,5,2,4]
        //
        //示例 2:
        //
        //输入: head = [2,1,3,5,6,4,7]
        //输出: [2,3,6,7,1,5,4]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/odd-even-linked-list
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        if(head == null || head.next == null)return head;
        ListNode odd_tail = head;
        ListNode even_head = head.next;
        ListNode even_tail = even_head;
        while(odd_tail.next != null && even_tail.next != null){
            odd_tail.next = even_tail.next;
            odd_tail = odd_tail.next;
            even_tail.next = odd_tail.next;
            even_tail = even_tail.next;
        }
        odd_tail.next = even_head;
        return head;
    }
}
class Solution2 {
    //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    //
    //
    //
    //示例 1：
    //
    //输入：head = [4,2,1,3]
    //输出：[1,2,3,4]
    //
    //示例 2：
    //
    //输入：head = [-1,5,3,4,0]
    //输出：[-1,0,3,4,5]
    //
    //示例 3：
    //
    //输入：head = []
    //输出：[]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/sort-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode h = new ListNode(0);
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode cur = h;
        while(left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }else{
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;
        return cur.next;
    }
}
class Solution1 {
    //给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
    //
    //删除完毕后，请你返回最终结果链表的头节点。
    //
    //
    //
    //你可以返回任何满足题目要求的答案。
    //
    //（注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode ret = new ListNode(-1, head);
        ListNode p = head;
        int sum = 0;
        map.put(0,ret);
        while(p != null){
            sum += p.val;
            if(map.containsKey(sum)){
                ListNode node = map.get(sum);
                ListNode tmp = node.next;
                node.next = p.next;

                int dSum = sum;
                while(tmp != p){
                    dSum += tmp.val;
                    map.remove(dSum);
                    tmp = tmp.next;
                }

            }else{
                map.put(sum, p);
            }
            p = p.next;
        }
        return ret.next;

    }
}
public class Test {
}
