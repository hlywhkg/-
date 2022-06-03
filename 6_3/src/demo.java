/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/3 17:41
 * @Version 1.0
 */

class Solution2 {
    public int numFriendRequests(int[] ages) {
        int[] tmp = new int[121];
        for (int i = 0; i < 121; i++) {
            tmp[ages[i]]++;
        }
        int ret[] = new int[121];
        for (int i = 1; i < 121; i++) {
            ret[i] = ret[i-1] + tmp[i];
        }
        int count = 0;
        for (int i = 15; i < 121; i++) {
            if(tmp[i] > 0){
                int r = (int) (i * 0.5 + 7);
                count += tmp[i] * (ret[i] - ret[r] - 1);
            }
        }
        return count;
    }
}

class Solution {
    public int consecutiveNumbersSum(int n) {
        int a = 2 * n;
        int count = 0;
        for (int i = 1; i * i< a; i++) {
            if(a % i != 0){
                continue;
            }else{
                if((a / i - i + 1) % 2 == 0){
                    count++;
                }
            }
        }
        return count;
    }
}


public class demo {
}
