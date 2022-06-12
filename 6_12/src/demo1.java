import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/12 21:06
 * @Version 1.0
 */


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> map = new LinkedList<>();
        int[]num1 = new int[26],num2 = new int[26];
        for (String str: words) {
            boolean flg = true;
            Arrays.fill(num1,-1);
            Arrays.fill(num2,0);
            for (int i = 0; i < pattern.length(); i++) {
                int x = str.charAt(i),y = pattern.charAt(i);
                if(num1[x] == -1 && num1[y] == 0){
                    x = y;
                    y = 1;
                }else if(num1[x] != y){
                    flg = false;
                }
            }
            if(flg){
                map.add(str);
            }
        }
        return map;
    }
}


public class demo1 {
}
