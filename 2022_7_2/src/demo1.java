import java.util.PriorityQueue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/2 10:19
 * @Version 1.0
 */

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        int remain = startFuel,ans = 0,ret = 0;
        int n = stations.length,idx = 0;
        while(ans < target){
            if(remain == 0){
                 if(!p.isEmpty() && ++ret >= 0)remain += p.poll();
                 else return -1;
            }
            ans += remain;
            remain = 0;
            while(idx < n && stations[idx][0] < ans)p.add(stations[idx++][1]);
        }
        return ret;
    }
}

public class demo1 {
    public static void main(String[] args) {

    }
}
