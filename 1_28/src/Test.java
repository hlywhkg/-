import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/28 13:55
 * @Version 1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution3 {
    // 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //[
    //[1,2,8,9],
    //[2,4,9,12],
    //[4,7,10,13],
    //[6,8,11,15]
    //]
    //
    //给定 target = 7，返回 true。
    //给定 target = 3，返回 false。
    //
    //数据范围：矩阵的长宽满足 0≤n,m≤5000 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0≤val≤1090 \le val \le 10^90≤val≤109
    //进阶：空间复杂度 O(1)O(1)O(1) ，时间复杂度 O(n+m)O(n+m)O(n+m)
    public boolean Find(int target, int [][] array) {
        int i  = 0;
        int j = array[0].length - 1;
        while(i < array.length && j >= 0){
            if(target > array[i][j]){
                i++;
            }else if(target < array[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
class Solution2 {
    //反转链表
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        ListNode cur = null;
        ListNode prev = head;
        while(prev != null && prev.next != null ){
            ListNode ret = prev.next;
            prev.next = cur;
            cur = prev;
            prev = ret;
        }
        prev.next = cur;
        return prev;
    }
}
class Solution1 {
    //反转链表并用数组存储返回数组
    int []arr;
    public int[] reversePrint(ListNode head) {
        if(head == null)return arr;
        ListNode cur = null;
        ListNode prev = head;
        int count = 0;
        while(prev != null && prev.next != null){
            ListNode ret = prev.next;
            head.next = cur;
            cur = head;
            head = ret;
            count++;
        }
        prev.next = cur;
        arr = new int[count - 1];
        for (int i = 0; i < count; i++) {
            arr[i] = prev.val;
            prev = prev.next;
        }
        return arr;
    }
}
public class Test {
    static int arr[];
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(3&1);//按位
        System.out.println(2&1);
    }
}
