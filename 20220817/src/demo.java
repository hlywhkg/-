import java.util.ArrayDeque;
import java.util.ArrayList;
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

class Solution8 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode slow = pHead,fast = pHead;
        for(int i = 0; i < k ; i++) {
            if(fast != null){
                fast = fast.next;
            }else{
                return null;
            }
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class Solution7 {
    //返回有环链表的入口
    //判断有没有环，返回相遇的地方
    public ListNode hasCycle(ListNode head) {
        //先判断链表为空的情况
        if(head == null)
            return null;
        //快慢双指针
        ListNode fast = head;
        ListNode slow = head;
        //如果没环快指针会先到链表尾
        while(fast != null && fast.next != null){
            //快指针移动两步
            fast = fast.next.next;
            //慢指针移动一步
            slow = slow.next;
            //相遇则有环，返回相遇的位置
            if(fast == slow)
                return slow;
        }
        //到末尾说明没有环，返回null
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);
        //没有环
        if(slow == null)
            return null;
        //快指针回到表头
        ListNode fast = pHead;
        //再次相遇即是环入口
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}


class Solution6 {
    //判断链表是否有环
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

class Solution5 {
    //合并多个有序链表
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divide(lists,0,lists.size()-1);
    }
    public ListNode divide(ArrayList<ListNode> list, int left,int right){
        if(left > right){
            return null;
        }else if(left == right){
            return list.get(left);
        }
        int mid = (left + right) / 2;
        return Merge(divide(list,left,mid),divide(list,mid + 1,right));
    }
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}

class Solution4 {
    //合并两个有序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}

class Solution3 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    //反转多组链表
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
    //反转链表区间
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
    //反转链表
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
