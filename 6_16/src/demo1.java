import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/16 21:47
 * @Version 1.0
 */

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int x: nums) {
            map.put(x,map.getOrDefault(x,1)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(map.containsKey(k-x)){
                count++;
                map.remove(x);
                map.remove(k-x);
            }
        }
        return count;
    }
}

public class demo1 {
}
