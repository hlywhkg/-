import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/13 22:10
 * @Version 1.0
 */

class NumArray {


    int[]ret;
    public NumArray(int[] nums) {
        int n = nums.length;
        ret = new int[n]
    }

    public void update(int index, int val) {

    }

    public int sumRange(int left, int right) {

    }
}

class Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length,m = arr.length;
        int[] tmp = new int[m+1];
        for (int i = 1; i <= m; i++) {
            tmp[i] = tmp[i-1] ^ arr[i];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int l = queries[i][0] + 1,r = queries[i][1] + 1;
            ret[i] = tmp[r] ^ tmp[l - 1];
        }
        return ret;
    }
}

class Solution1 {
    public int heightChecker(int[] heights) {
        int[] temp = Arrays.copyOf(heights,heights.length);
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(temp[i] != heights[i]){
                count++;
            }
        }
        return count;
    }
}


public class demo1 {
    public static void main(String[] args) {

    }
}
