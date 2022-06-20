/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/20 22:04
 * @Version 1.0
 */

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flg = false;
            for (int[]arr: ranges) {
                int l = arr[0],r = arr[1];
                if(i >= l && l <= r){
                    flg = true;
                    break;
                }
            }
            if(!flg)return false;
        }
        return true;
    }
}

public class demo1 {
}
