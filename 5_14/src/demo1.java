import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/14 19:19
 * @Version 1.0
 */

class Solution1 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < nums.length;i++) {
            if(i + 1 == nums.length || nums[i] + 1 != nums[i+1]){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[j]);
                if(i != j){
                    sb.append("->" + nums[i]);
                }
                list.add(sb.toString());
                j = i + 1;
            }
        }
        return list;
    }
}
public class demo1 {
}
