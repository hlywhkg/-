import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/17 22:20
 * @Version 1.0
 */

class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        sum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1-1][col1-1];
    }
}

class Solution3 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}

class Solution2 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //左上角
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                //右下角
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);
                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ret[i][j] = tot / cnt;
            }
        }
        return ret;
    }
}

class Solution1 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0 , j = 0;
        while(j < n){
            if(arr[i] == 0)j++;
            i++;j++;
        }
        i--;j--;
        while(i >= 0){
            if(j < n)arr[j] = arr[i];
            if(arr[i] == 0 && --j >= 0)arr[j] = 0;
            i--;j--;
        }
    }
}

public class demo1 {
}
