import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/18 12:32
 * @Version 1.0
 */


class ListNode {
    int val;
    public ListNode(int val){
        this.val = val;
    }
    ListNode next = null;
}

class Solution7 {
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode ret = cur.next;
            if(cur.val == ret.val){
                cur.next = ret.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}

class Solution6 {
    //将链表中奇数位和偶数位的分别放在一起
    //使用快慢指针
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head == null || head.next == null)return head;
        ListNode even = head.next,odd = head;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


class Solution5 {

    //判断链表是否是一个回文链表
    //走到链表中间，反转后半部分链表
    //从头判断和从反转后的链表头一直判断即可
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        int n = 0;
        ListNode ret = head;
        while(ret != null){
            n++;
            ret = ret.next;
        }
        n = n / 2;
        ret = head;
        for(int i = 0 ; i < n ; i++) {
            ret = ret.next;
        }
        ListNode prev = null;
        while(ret != null){
            ListNode tmp = ret.next;
            ret.next = prev;
            prev = ret;
            ret = tmp;
        }
        ListNode cur = head;
        while(prev != null){
            if(prev.val != cur.val){
                return false;
            }
            prev = prev.next;
            cur = cur.next;
        }
        return true;
    }
}

class Solution4 {
    //单链表的排序
    //首先将一个单链表从中间断开，分成一个个的链表
    //使用归并排序
    public ListNode Merge(ListNode l1,ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        if(l1.val <= l2.val){
            l1.next = Merge(l1.next,l2);
            return l1;
        }else{
            l2.next = Merge(l1,l2.next);
            return l2;
        }
    }
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head,mid = head,right = head;
        while(right != null && right.next != null){
            prev = mid;
            mid = mid.next;
            right = right.next.next;
        }
        prev.next = null;
        return Merge(sortInList(head),sortInList(mid));
    }
}

class Solution3 {
    //链表相加，使用栈
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        ListNode l1 = head1,l2 = head2;
        while(l1 != null){
            d1.addLast(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            d2.addLast(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;
        ListNode ret = null;
        int carry = 0;
        while(!d1.isEmpty() || !d2.isEmpty() || carry != 0){
            int x = d1.isEmpty() ? 0 : d1.pollLast();
            int y = d2.isEmpty() ? 0 : d2.pollLast();
            int sum = x + y + carry;
            carry = sum / 10;
            ret = new ListNode(sum % 10);
            ret.next = cur;
            cur = ret;
        }
        return cur;
    }
}

class Solution2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}

class Solution1 {
    //删除倒数第n个节点
    /**
     *
     * @param _head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode _head, int n) {
        // write code here
        ListNode head = new ListNode(0);
        head.next = _head;
        ListNode fast = head, slow = head;
        for(int i = 0 ; i < n ; i++) {
            fast = fast.next;
            System.out.println(fast.val);
        }
        ListNode prev = head;
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        System.out.println("r"+prev.val);
        System.out.println("r"+slow.val);
        prev.next = slow.next;
        return head.next;
    }
}
public class demo1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = s.removeNthFromEnd(head,3);
        while(head != null){
            System.out.println("main"+head.val);
            head = head.next;
        }
    }
}
