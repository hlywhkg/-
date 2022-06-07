/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/7 21:49
 * @Version 1.0
 */

class Solution2 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] pre = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*'){
                count++;
            }
            pre[i] = count;
        }

        int[] left = new int[n];
        for (int i = 0, j = -1; i < n; i++) {
            if(s.charAt(i) == '|'){
                j = i;
            }
            left[i] = j;
        }

        int[] right = new int[n];
        for (int i = n - 1, j = - 1; i >= 0; i--) {
            if(s.charAt(i) == '|'){
                j = i;
            }
            right[i] = j;
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ret[i] = x == -1 || y == -1 || x >= y ? 0 : pre[y] - pre[x];
        }
        return ret;
    }
}

class Solution1 {

    public boolean check(int[]p,int speed,int h){
        int ret = 0;
        for (int i = 0; i < p.length; i++) {
            ret += Math.ceil(p[i] * 1.0 / speed);
        }
        return ret <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for (int i = 1; i < n; i++) {
            if(max < piles[i]){
                max = piles[i];
            }
        }
        if(n == h){
            return max;
        }
        int l = 0;
        while(l < max){
            int mid = l + max >> 1;
            if(check(piles,mid,h)){
                max = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}


public class demo1 {
    public static void main(String[] args) {
        for (int i = 0 , j = -1; i < 10 ; i++) {
            if(i == 5){
                j = 10;
            }
            System.out.println(j);
        }
    }
}
