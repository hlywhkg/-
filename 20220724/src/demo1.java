/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/24 17:42
 * @Version 1.0
 */

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int row = in.nextInt();
            int col = in.nextInt();
            Deque<int[]> d = new ArrayDeque<>();
            int[][] ret = new int[row][col];
            boolean[][] flg = new boolean[row][col];
            for(int i = 0 ; i < row ; i++) {
                for(int j = 0; j < col ; j++) {
                    ret[i][j] = in.nextInt();
                }
            }
            d.addLast(new int[]{0,0});
            flg[0][0] = true;
            bfs(ret,d,flg);
            while(!d.isEmpty()){
                int[] tmp = d.pollFirst();
                int x = tmp[0],y = tmp[1];
                System.out.println("(" + x +"," + y + ")");
            }
        }
    }
    static int[][] dict = new int[][]{{1,0},{0,1}};
    public static void bfs(int[][] ret,Deque<int[]> d,boolean[][] flg){
        while(!d.isEmpty()) {
            int[] ans = d.peekLast();
            int x = ans[0], y = ans[1];
            int m = ret.length, n = ret[0].length;
            if (x == m - 1 && y == n - 1) break;
            for (int[] cnt : dict) {
                int nx = x + cnt[0], ny = y + cnt[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (ret[nx][ny] == 1) continue;
                if (flg[nx][ny]) continue;
                d.addLast(new int[]{nx, ny});
                System.out.println(Arrays.toString(ans));
                flg[nx][ny] = true;
                bfs(ret, d, flg);
            }
            d.pollLast();
        }
    }
}

public class demo1 {
}
