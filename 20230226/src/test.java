import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/2/26 21:09
 * @Version 1.0
 */

class Solution {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode> stack1 = new Stack<>(),stack2 = new Stack<>();
        ListNode p1 = head1,p2 = head2;
        while(p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while(p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        ListNode head = new ListNode(-1);
        int cur = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int tmp;
            if(stack1.isEmpty()){
                tmp = stack2.pop().val + cur;
            }else if(stack2.isEmpty()){
                tmp = stack1.pop().val + cur;
            }else {
                tmp  = stack1.pop().val+stack2.pop().val + cur;
            }
            //int tmp  = stack1.pop().val+stack2.pop().val + cur;
            System.out.println(tmp);
            int val = tmp % 10;
            ListNode ret = new ListNode(val);
            System.out.println(ret.val);
            ret.next = head.next;
            head.next = ret;
            if(tmp >= 10){
                cur = 1;
            }else {
                cur = 0;
            }
        }
        if(cur != 0) {
            ListNode t = head.next,r = new ListNode(cur);
            head.next = r;
            r.next = t;
        }
        return head.next;
    }
}

public class test {
    public static void main(String[] args) {
        Solution.ListNode listNode1 = new Solution.ListNode(9);
        listNode1.next = new Solution.ListNode(3);
        listNode1.next.next = new Solution.ListNode(7);
        Solution.ListNode listNode2 = new Solution.ListNode(6);
        listNode2.next = new Solution.ListNode(3);
        Solution s = new Solution();
        System.out.println(s.addInList(listNode1, listNode2).val);
    }
}
