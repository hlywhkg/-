import java.util.Random;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/9 21:22
 * @Version 1.0
 */

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n + 1];
        for (int i = 0 ; i < bookings.length ; i++){
            int l = bookings[i][0] - 1,r = bookings[i][1] - 1,count = bookings[i][2];
            ret[l] += count;
            ret[r + 1] -= count;
        }
        int[] tmp = new int[n];
        tmp[0] = ret[0];
        for (int i = 1; i < n; i++) {
            tmp[i] = ret[i] + tmp[i-1] ;
        }
        return tmp;
    }
}

class Solution1 {

    int[] prev;
    int[][] rs;
    int n;
    public Solution1(int[][] rects) {
        n = rects.length;
        rs = rects;
        prev = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int ret = (rects[i-1][2] - rects[i-1][0]) * (rects[i-1][3] - rects[i-1][1]);
            prev[i] = prev[i-1] + ret;
        }
    }

    public int[] pick() {
        Random random = new Random();
        int val = random.nextInt(prev[n])+1;
        int l = 0,r = n;
        while(l < r){
            int mid = l + r >> 1;
            if(prev[mid] < val){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        int[] ret = rs[r-1];
        int x = random.nextInt(ret[2] - ret[0] + 1) + ret[0], y = random.nextInt(ret[3] - ret[1] + 1) + ret[1];
        return new int[]{x,y};
    }
}

public class demo1 {
}
