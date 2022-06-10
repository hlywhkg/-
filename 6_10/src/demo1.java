import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/10 21:47
 * @Version 1.0
 */

class Solution {
    static int[] tmp = new int[10000+1];
    public void add(int l, int r){
        tmp[l] += 1;
        tmp[r] -= 1;
    }
    public int bestRotation(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = (i - (n - 1) + n ) % n, b = (i - nums[i] + n) % n;
            if(a <= b){
                add(a,b);
            }else{
                add(0,b);
                add(a,n-1);
            }
        }
        for (int i = 1; i <= n; i++) {
            tmp[i] += tmp[i-1];
        }
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if(tmp[i] > tmp[ret]){
                ret = i;
            }
        }
        return ret;
    }
}

class Solution1 {
    int MOD = (int)1e9+7;
    public int countPalindromicSubsequences(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] f = new int[n][n];
        int[] L = new int[4], R = new int[4];
        Arrays.fill(L, -1);
        for (int i = n - 1; i >= 0; i--) {
            L[cs[i] - 'a'] = i;
            Arrays.fill(R, -1);
            for (int j = i; j < n; j++) {
                R[cs[j] - 'a'] = j;
                for (int k = 0; k < 4; k++) {
                    if (L[k] == -1 || R[k] == -1) continue;
                    int l = L[k], r = R[k];
                    if (l == r) f[i][j] = (f[i][j] + 1) % MOD;
                    else if (l == r - 1) f[i][j] = (f[i][j] + 2) % MOD;
                    else f[i][j] = (f[i][j] + f[l + 1][r - 1] + 2) % MOD;
                }
            }
        }
        return f[0][n - 1];
    }
}

public class demo1 {
}
