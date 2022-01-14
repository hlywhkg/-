import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/14 10:41
 * @Version 1.0
 */
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 *//*

class Solution3 extends GuessGame {
    //猜数字游戏的规则如下：
    //
    //    每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
    //    如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
    //
    //你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
    //
    //    -1：我选出的数字比你猜的数字小 pick < num
    //    1：我选出的数字比你猜的数字大 pick > num
    //    0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
    //
    //返回我选出的数字。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int guessNumber(int n) {
        int left = 1,right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            int ret = guess(mid);
            if(ret == -1){
                right = mid - 1;
            }else if(ret == 0)return mid;
            if (ret == 1){
                left = mid + 1;
            }
        }
        return left;
    }
}*/
class Solution2 {
    //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
    //输入: 38
    //输出: 2
    //解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/add-digits
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    int change(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    public int addDigits(int num) {
        while(num >= 10){
            num = change(num);
        }
        return num;
    }
}
class Solution1 {
    //给定两个字符串 s 和 t，判断它们是否是同构的。
    //
    //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
    //
    //每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/isomorphic-strings
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isIsomorphic(String s, String t) {
        //K - V大法
        Map<Character,Character>hash = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            if(!hash.containsKey(s.charAt(i))) {
                if(hash.containsValue(t.charAt(i))){
                    return false;
                }
                hash.put(s.charAt(i), t.charAt(i));
            }else if(hash.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
public class Test {
    public int a;
    public static void main(String[] args) {
        Map<Character,Character>hash = new Hashtable<>();
        hash.put('a','b');
        System.out.println(hash.containsKey('a'));
        System.out.println(hash.get('a'));
       // System.out.println(a);
        Integer a = new Integer(1);
        Integer b = a;
        fun(a);
        System.out.println(a);
        System.out.println(a==b);
    }
    static void fun(Integer a){
        a = new Integer(2);
    }
}
