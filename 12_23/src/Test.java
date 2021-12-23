/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/23 8:54
 * @Version 1.0
 */
class Solution1 {
    //实现 strStr() 函数。
    //
    //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
    //
    //
    //
    //说明：
    //
    //当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    //
    //对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/implement-strstr
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);//搞不懂的官方，一行搞定？
        if(needle==""||haystack=="")return 0;//常规解法
        if(haystack.length()<needle.length())return -1;
        int l1=0,l2=0,s1=haystack.length()-1,s2=needle.length()-1;
        while(l1 <= s1&&l2 <= s2){
            int index = l1;
            if(haystack.charAt(l1) == needle.charAt(l2)){
                l1++;
                l2++;
            }
            if(l2==s2){
                return index;
            }else {
                l1 = index+1;
                l2 = 0;
            }
        }
        return -1;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int ret = solution.strStr("" ,"");
        System.out.println(ret);
    }
}
