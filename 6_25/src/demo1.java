import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/25 21:46
 * @Version 1.0
 */



class MyCalendar {
    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int a = costs[0][0],b = costs[0][1],c = costs[0][2];
        for (int i = 1; i < n; i++) {
            int d = Math.min(b,c) + costs[i][0];
            int e = Math.min(a,c) + costs[i][1];
            int f = Math.min(a,b) + costs[i][2];
            a = d;b = e;c = f;
        }
        return Math.min(a,Math.min(b,c));
    }
}

public class demo1 {
}
