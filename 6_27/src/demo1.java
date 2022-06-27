/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/27 20:18
 * @Version 1.0
 */

class Solution {
    public boolean check(String a,String b){
        int m = a.length(),n = b.length();
        if(m > n)return false;
        int[][]arr = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = (a.charAt(i-1) == b.charAt(j-1)) ? arr[i-1][j-1] + 1 : arr[i-1][j-1];
                arr[i][j] = Math.max(arr[i-1][j],Math.max(arr[i][j],arr[i][j-1]));
                if(arr[i][j] == m)return true;
            }
        }
        return false;
    }
    public int findLUSlength(String[] strs) {
        int n = strs.length,ret = -1;
        for (int i = 0; i < n; i++) {
            if(strs[i].length() <= ret)continue;
            boolean flg = true;
            for (int j = 0; j < n && flg; j++) {
                if(i==j)continue;
                if(check(strs[i],strs[j]))flg=false;
            }
            if (flg)ret = strs[i].length();
        }
        return ret;
    }
}

public class demo1 {
}
