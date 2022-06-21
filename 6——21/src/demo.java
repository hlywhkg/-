/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/21 20:43
 * @Version 1.0
 */



class Solution2 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + chalk[i-1];
        }
        long ret = k % sum[n];
        for (int i = 1; i <= n; i++) {
            if(sum[i] > ret){
                return i - 1;
            }
        }
        return -1;
    }
}

class Solution1 {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}

public class demo {
}
