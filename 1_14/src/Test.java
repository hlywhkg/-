import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/14 10:41
 * @Version 1.0
 */
class Solution {
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
    public static void main(String[] args) {
        Map<Character,Character>hash = new Hashtable<>();
        hash.put('a','b');
        System.out.println(hash.containsKey('a'));
        System.out.println(hash.get('a'));
    }
}
