import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/6 10:19
 * @Version 1.0
 */



class Solution3 {
    //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    //
    //请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    //
    //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中.
    //为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //常规双指针解法
        /*int l1 = 0,l2 = 0;
        int []arr = new int[m+n];
        int count = 0;
        while(l1 < m && l2 < n){
            if(nums1[l1] <= nums2[l2]){
                arr[count++] = nums1[l1++];
            }else {
                arr[count++] = nums2[l2++];
            }
        }
        while(l1 == m){
            arr[count++] = nums2[l2++];
            if(l2 == n){
                break;
            }
        }
        while(l2 == n && l1 != m){
            arr[count++] = nums1[l1++];
            if(l1 == n){
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }*/
        //调用库函数
        for (int i = 0; i < n;i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
}
class Solution2 {
    //存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
    //
    //返回同样按升序排列的结果链表。
    //输入：head = [1,1,2]
    //输出：[1,2]
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public ListNode deleteDuplicates(ListNode head) {
        //1.常规思路，快慢指针解法，
        /*ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null && cur.next != null){
            if(cur.val == prev.val ){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(cur.val == prev.val)prev.next = null;
        return head;*/

        //2.递归思路
        /*if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;*/

        //3.递归简化
         if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
class Solution1 {
    //给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
    //
    //在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
    //
    //请注意，返回的 规范路径 必须遵循下述格式：
    //
    //    始终以斜杠 '/' 开头。
    //    两个目录名之间必须只有一个斜杠 '/' 。
    //    最后一个目录名（如果存在）不能 以 '/' 结尾。
    //    此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
    //
    //返回简化后得到的 规范路径 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/simplify-path
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();//双端队列，既可当栈还可当队列使用
        int len = path.length();
        for (int i = 0; i < len;) {
            if(path.charAt(i) == '/' && ++i >= 0)continue;
            int j = i +1;
            while(j<len&&path.charAt(j) != '/')j++;
            String item = path.substring(i,j);
            if(item.equals("..")){
                stack.pollLast();//删除队尾元素
            }else if(!item.equals(".")){
                stack.addLast(item);//添加队尾元素
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())sb.append("/"+stack.pollFirst());//获取并删除对头元素
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
public class Test {
    public static void main(String[] args) {
        int []a = {1,2,3,};//似乎可以这样做哎,b比a短也能保存，引用传递
        int []b = {2,5,6};
        int m = 3,n=3;
        Solution3 solution3 = new Solution3();
        solution3.merge(a,3,b,3);
    }
}
