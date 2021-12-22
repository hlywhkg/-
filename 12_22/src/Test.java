/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/22 8:29
 * @Version 1.0
 */

class Solution {
    //给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
    //
    //注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/repeated-string-match
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int repeatedStringMatch(String a, String b) {
        //a的长度要么比b长，那么b是a的子集，或者比b短，那么b是a的重复叠加子集即b=a[a,……,a]a,[]里代表重复个a，整体则代表最长的a的长度
        if(a == null || b == null)return -1;
        String temp = a;
        int cnt = 1, Asize = a.length(), Bsize = b.length(), midRepCnt = Bsize / Asize;
        while(cnt <= midRepCnt+2){
            if(temp.contains(b)){
                return cnt;
            }
            temp += a;
            cnt++;
        }
        return -1;
    }
}
public class Test {
    public static void main(String[] args) {
        String a = "aa";
        String b = a + a;
        System.out.println(b);
    }
}
