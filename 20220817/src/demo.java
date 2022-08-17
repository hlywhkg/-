import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/17 9:34
 * @Version 1.0
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution3 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(k <= 1 || head == null)return head;
        ListNode ret = new ListNode(0);
        ListNode now = ret;
        Deque<ListNode> d = new ArrayDeque<>();
        while(true){
            int cnt = 0;
            for(int i = 0; i < k; i++) {
                if(head == null)break;
                d.addLast(head);
                head = head.next;
                cnt++;
            }
            if(cnt == k){
                System.out.println(Arrays.toString(d.toArray()));
                while(!d.isEmpty()){
                    now.next = d.pollLast();
                    now = now.next;
                    System.out.println("now"+now.val);
                    //now.next = null;
                }
            }else{
                while(!d.isEmpty()){
                    now.next = d.pollFirst();
                    now = now.next;
                }
            }
            if(head == null){
                System.out.println("head is null");
                break;
            }
        }
        ListNode test = ret.next;
        while(test.next != null){
            System.out.println("函数内");
            System.out.println(test.val);
            test = test.next;
        }
        return ret.next;
    }
}

class Solution2 {
    public ListNode reverseBetween (ListNode _head, int m, int n) {
        // write code here
        ListNode head = new ListNode(-1);
        head.next = _head;
        ListNode prev = head;
        for(int i = 0 ; i < m - 1 ; i++){
            prev = prev.next;
        }
        ListNode right = prev;
        for(int i = 0 ; i < n - m + 1 ; i++){
            right = right.next;
        }
        ListNode left = prev.next;
        ListNode cur = right.next;

        prev.next = null;
        right.next = null;
        ListNode left_prev = null;
        ListNode ret = left;
        while(ret != null){
            ListNode tmp = ret.next;
            ret.next = left_prev;
            left_prev = ret;
            ret = tmp;
        }
        prev.next = right;
        left.next = cur;
        return head.next;
    }
}
class Solution1 {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        while(next != null){
            ListNode ret = next.next;
            next.next = prev;
            prev = next;
            next = ret;
        }
        return prev;

    }
}

public class demo {
    public static void main(String[] args) {
        int i = 0 , j = 0;
        /**
         * 编译报错？
         * 不支持for循环逗号表达式
         */
        /*for(i = 0;i < 5,j < 10; i++,j++){

        }*/
        /*for(i = 0 ; i < 3 ; i++){
            if(i == 3)break;
            System.out.println(i);
        }*/
        Solution3 s = new Solution3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = s.reverseKGroup(head,3);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
