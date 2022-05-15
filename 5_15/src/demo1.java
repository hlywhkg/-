import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/15 10:01
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

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head,ret = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            prev.next = ret;
            ret = prev;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(prev != null && slow != null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
public class demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = scan.nextInt();
        int x2 = scan.nextInt();
        int x3 = scan.nextInt();
        int x4 = scan.nextInt();
        System.out.println(x1+x2+x3+x4);
    }
}
