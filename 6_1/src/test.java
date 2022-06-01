import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/1 9:56
 * @Version 1.0
 */

class Solution {
    int[] ms;
    int t;
    public boolean makesquare(int[] _ms) {
        ms = _ms;
        int sum = 0;
        for (int i : ms) sum += i;
        t = sum / 4;
        if (t * 4 != sum) return false;
        Arrays.sort(ms);
        return dfs(ms.length - 1, new int[4]);
    }
    boolean dfs(int idx, int[] cur) {
        if (idx == -1) return true;
        out:for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                if (cur[j] == cur[i]) continue out;
            }
            int u = ms[idx];
            if (cur[i] + u > t) continue;
            cur[i] += u;
            if (dfs(idx - 1, cur)) return true;
            cur[i] -= u;
        }
        return false;
    }
}
class Solution2 {
    public int pivotIndex(int[] nums) {
        int[] ret = new int[nums.length+1];
        for (int i = 1; i < ret.length; i++) {
            ret[i] = nums[i-1] + ret[i-1];
        }
        for (int i = 0; i < ret.length; i++) {
            if(ret[ret.length-1] - ret[i] == ret[i]) {
                if(ret.length % 2 == 0){
                    return i-1;
                }else {
                    return i;
                }
            }
        }
        return -1;
    }
}
class NumArray {

    int[] num;
    public NumArray(int[] nums) {
        num = new int[nums.length + 1];
        for (int i = 1; i < num.length; i++) {
            num[i] = num[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return num[right+1] - num[left];
    }
}

class Solution1 {
    public int sumOddLengthSubarrays(int[] arr) {
        int ret[] = new int[arr.length + 1];
        //i下标代表前i-1个数的和
        for(int i = 1 ; i < ret.length ; i++) {
            ret[i] = ret[i-1] + arr[i-1];
        }
        int ans = 0;
        for (int gap = 1; gap <= arr.length; gap += 2) {
            for (int index = 0; index + gap - 1 < arr.length; index++) {
                int r = index + gap - 1;
                ans += ret[r + 1] - ret[index];
            }
        }
        return ans;
    }
}
public class test {

}
