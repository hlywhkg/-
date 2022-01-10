/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/10 11:06
 * @Version 1.0
 */
class Solution {
    public boolean isPalindrome(String s) {
        String []str = s.split("[^\\w]");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.reverse().toString().equals(s);
    }
}

public class Test {
    public static void main(String[] args) {
        String str = "race a car";
        Solution solution = new Solution();
        solution.isPalindrome(str);
    }
}
