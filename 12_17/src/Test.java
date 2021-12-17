import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/17 8:31
 * @Version 1.0
 */
class Solution1 {
    //小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
    //如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
    //请你计算 最多 能喝到多少瓶酒。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/water-bottles
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange){
            sum += emptyBottles/numExchange;
            emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;
        }
        return sum;
    }
}
class Solution2 {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //你可以按任意顺序返回答案。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {//暴力枚举双循环
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    if(i == j)continue;
                    else{
                        int [] arr={i,j};
                        return arr;
                    }
                }
            }
        }
        return null;
       /* Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();//哈希表查找与与之匹配相加等于target的数
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }else {
                hashtable.put(nums[i],i);
            }
        }
        return null;*/
    }
}
public class Test {

    public static void main(String[] args) {
        /*int a = 10;
        String str = Integer.toString(a);
        System.out.println(str);*/
    }
}
