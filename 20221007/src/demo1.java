import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/7 22:56
 * @Version 1.0
 */

class Solution {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int n = numbers.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int ret = target - numbers[i];
            if(!map.containsKey(ret)){
                map.put(numbers[i],i);
            }else{
                return new int[]{map.get(ret)+1,i+1};
            }
        }
        return new int[]{};
    }
}

public class demo1 {
}
