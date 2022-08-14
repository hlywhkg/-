import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 8:15
 * @Version 1.0
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs("",n,n,list);
        return list;
    }

    public void dfs(String str, int left, int right, List<String> list){
        if(left == 0 && right == 0){
            list.add(str);
            return;
        }
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(str + "(",left-1,right,list);
        }

        if(right > 0){
            dfs(str+")",left,right-1,list);
        }
    }
}

class Solution1 {
    public void sortColors(int[] nums) {
        int num0 = 0,num1= 0,num2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1){
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else{
                nums[num2++] = 2;
            }
        }
    }
}

class ThisTest {
    public static void main(String args[]) {
        String x="7";
        int y = 2;
        int z = 2;
        System.out.println(x+y+z);
    }
}

public class demo {
}
