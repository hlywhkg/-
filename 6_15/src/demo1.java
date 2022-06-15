import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/15 21:29
 * @Version 1.0
 */

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] ret = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i-1] + arr[i-1];
        }
        int sum = 0;
        for (int tap = 1; tap < n; tap += 2) {
            for (int i = 0; i + tap - 1 < n; i++) {
                int r = i + tap - 1;
                sum += ret[r+1] - ret[i];
            }
        }
        return sum;
    }
}

class Solution2 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int[] ret = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if()
        }
    }
}

class NumArray {
    int[] ret;
    public NumArray(int[] nums) {
        int n = nums.length;
        ret = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return ret[right - 1] - ret[left-1];
    }
}


class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int)1e6;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    int check(int[] nums, int x) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= x) j++;
            ans += j - i - 1;
        }
        return ans;
    }
}

public class demo1 {
}
