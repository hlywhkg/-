import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/4 18:56
 * @Version 1.0
 */

class Solution {
    int[] pre;
    public Solution(int[] w) {
        pre = new int[w.length+1];
        for (int i = 1; i <= w.length; i++) {
            pre[i] = pre[i-1] + w[i-1];
        }
    }

    public int pickIndex() {
        int t = (int)(Math.random() * pre[pre.length-1]) + 1;
        int l = 0,r = pre.length-1;
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(pre[mid] >= t){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r - 1;
    }
}

class Solution1 {
    public String Split(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();) {
            char c = str.charAt(i);
            if(c == '@'){
                sb.append(str,i,str.length());
                break;
            }
            if(c != '.' && c != '+'){
                sb.append(c);
                i++;
            }
            if(c == '.')i++;
            if(c == '+'){
                while(c != '@'){
                    i++;
                    c = str.charAt(i);
                }
            }
        }
        return sb.toString();
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        int count = 0;
        for (int i = 0; i < emails.length; i++) {
            s.add(Split(emails[i]));
        }
        return s.size();

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String str[] = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(s.numUniqueEmails(str));

    }
}

public class demo {
    public static void main(String[] args) {

    }
}
