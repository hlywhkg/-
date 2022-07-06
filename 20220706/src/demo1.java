import com.sun.imageio.plugins.common.I18N;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/6 10:49
 * @Version 1.0
 */

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    d.addLast(new int[]{i,j});
                    map.put(i * n + j,0);
                }
            }
        }
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int max = -1;
        while(!d.isEmpty()){
            int[] ret = d.pollFirst();
            int x = ret[0],y = ret[1];
            int steps = map.get(x * n + y);
            for (int[] a : dirs) {
                int nx = x + a[0],ny = y + a[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)continue;
                if(grid[nx][ny] != 0)continue;
                grid[nx][ny] = steps + 1;
                d.addLast(new int[]{nx,ny});
                map.put(nx * n + ny,steps + 1);
                if(max < steps + 1){
                    max = steps + 1;
                }
            }
        }
        return max;
    }
}

public class demo1 {
}
