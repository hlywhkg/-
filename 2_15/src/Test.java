/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/15 14:11
 * @Version 1.0
 */
import java.util.Arrays;
import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    //相交的两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = ( p1 == null ? headB : p1.next);
            p2 = ( p2 == null ? headA : p2.next);
        }
        return p1;
    }
}
class Main{
    //输入描述：
    //第一行包含T，测试数据的组数。后面跟有T行，每行包含一个字符串。
    //输出描述：
    //如果可以删去一个字母使它变成回文串，则输出任意一个满足条件的删去字母的位置（下标从0开始）。例如：
    //
    //bcc
    //
    //我们可以删掉位置0的b字符。
    //示例1
    //输入：
    //
    //3
    //aaab
    //baa
    //aaa
    //
    //输出：
    //
    //3
    //0
    //-1
    public static boolean IsPalindrome(StringBuffer sb,int[] start,int end[]){
        int i = 0;
        int j = sb.length() - 1;
        boolean flg = true;
        while(i < j){
            if(sb.charAt(i) == sb.charAt(j)){
                i++;
                j--;
            }else{
                flg = false;
                break;
            }
        }
        if(start != null){
            start[0] = i;
        }
        if(end != null){
            end[0] = j;
        }
        return flg;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num > 0){
            int start[] = new int[1];
            int end[] = new int[1];
            StringBuffer sb = new StringBuffer(scanner.next());
            if(IsPalindrome(sb,start,end)){
                System.out.println(-1);
            }else{
                sb.deleteCharAt(end[0]);
                if(IsPalindrome(sb,null,null)){
                    System.out.println(end[0]);
                }else{
                    System.out.println(start[0]);
                }
            }
            num--;
        }
    }
}

class Solution1 {
    // 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
    //数据范围:
    //1<=n<=2×1051 <= n <= 2\times10^51<=n<=2×105
    //−100<=a[i]<=100-100 <= a[i] <= 100−100<=a[i]<=100
    //
    //要求:时间复杂度为 O(n)O(n)O(n)，空间复杂度为 O(n)O(n)O(n)
    //进阶:时间复杂度为 O(n)O(n)O(n)，空间复杂度为 O(1)O(1)O(1)
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1)return array[0];
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for(int i = 1 ; i < array.length; i++){
            dp[i] = Math.max(array[i],dp[i-1] + array[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
public class Test {
    public static void main(String[] args) {
        String.valueOf("1");
    }
}
