/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/29 20:40
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

public class demo1 {
}
