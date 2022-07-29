/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/30 12:55
 * @Version 1.0
 */

class Solution {
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 3; i <= n; i++) {
            boolean flg = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    flg = false;
                    break;
                }
            }
            if(flg)count++;
        }
        int ret = (count * count + (n - count) * (n - count)) % (int)(1e9 + 7);
        return ret;
    }
}

public class demo1 {
}
