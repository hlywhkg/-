/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/11 19:54
 * @Version 1.0
 */

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] arr = new int[n + 1];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += arr[i];
            if ((nums[i] + ret) % 2 == 0) {
                if (i + k > n) return -1;
                arr[i + 1]++;
                arr[i + k]--;
                ans++;
            }
        }
        return ans;
    }
}

class Solution1 {
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length, ans = n;
        int[] prev = new int[n + 10];
        for (int i = 1; i <= n; i++) prev[i] = prev[i - 1] + (c[i - 1] - '0');
        for (int i = 1; i <= n; i++) {
            int l = prev[i - 1], r = (n - i) - (prev[n] - prev[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }
}

public class demo1 {
}
