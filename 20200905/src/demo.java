import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/5 15:57
 * @Version 1.0
 */

class Solution2 {
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        for(int x : nums){
            for(int i = 0 ; i < 32 ; i++) {
                if(((x >> i) & 1) == 1){
                    cnt[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(cnt));
        int ans = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(cnt[i] % 3 != 0){
                ans += (1<<i);
            }
        }
        return ans;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

/**
 * id&1 判断奇偶
 * select * from cinema where description != 'boring' and id & 1 order by rating desc
 */

/**
 * distinct去除重复项
 * select distinct(a.Email) from Person a join Person b on a.id != b.id and a.Email = b.Email;
 */

public class demo {
    public static void main(String[] args) {
        System.out.println(3|4);
        System.out.println(2|3);
        Solution2 s = new Solution2();
        System.out.println(s.singleNumber(new int[]{1, 1, 1, 2}));

    }
}
