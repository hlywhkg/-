import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/23 20:31
 * @Version 1.0
 */

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int w = words[0].length(), m = words.length,n = s.length();
        //记录word中的单词次数，为后续比较做准备
        Map<String,Integer> map = new HashMap<>();
        for (String str: words) {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            Map<String,Integer> temp = new HashMap<>();
            for (int j = i; j + w <= n ; j += w) {
                String ret = s.substring(j,j+w);
                temp.put(ret,temp.getOrDefault(ret,0)+1);
                if(j - i >= m * w){
                    int index = j - m * w;
                    String str = s.substring(index,index+w);
                    if(temp.get(str) == 1)temp.remove(str);
                    else temp.put(str,temp.get(str)-1);
                    if(!temp.getOrDefault(ret,0).equals(map.getOrDefault(ret,0)))continue;
                }
                if(!temp.getOrDefault(ret,0).equals(map.getOrDefault(ret,0)))continue;
                if(temp.equals(map))list.add(j-(m-1)*w);
            }
        }
        return list;
    }
}

public class demo1 {
}
