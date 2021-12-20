import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/20 8:38
 * @Version 1.0
 */
class Solution {
    //冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
    //
    //在加热器的加热半径范围内的每个房屋都可以获得供暖。
    //
    //现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
    //
    //说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/heaters
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int findRadius(int[] houses, int[] heaters) {//朴素解法
        Arrays.sort(houses);          //对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离
        Arrays.sort(heaters);         //最后求所有热水器最大的距离
        int i = 0,j = 0,ans = 0;
        while(i < houses.length){
            while(j < heaters.length && houses[i] >= heaters[j]){
                j++;
            }
            if(j == 0){
                ans = Math.max(ans,heaters[j] - houses[i]);
            }else if(j == heaters.length){
                ans = Math.max(ans,houses[i] - heaters[j-1]);
            }else {
                ans = Math.max(ans,Math.min(houses[i] - heaters[j-1],heaters[j] - houses[i]));
            }
            ++i;
        }
        return ans;
    }
}

