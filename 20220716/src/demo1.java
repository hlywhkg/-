import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/16 10:47
 * @Version 1.0
 */

class Solution {
    int[][] grid;
    boolean[][] ans;
    Deque<int[]> d;
    int m,n;
    public int numEnclaves(int[][] _grid) {
        grid = _grid;
        m = grid.length;n = grid[0].length;
        ans = new boolean[m][n];
        d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    if(grid[i][j] == 0)continue;
                    ans[i][j] = true;
                    d.addLast(new int[]{i,j});
                }
            }
        }
        bfs();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!ans[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    int[][] dict = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public void bfs(){
        while(!d.isEmpty()){
            int[] ret = d.pollFirst();
            int x = ret[0],y = ret[1];
            for (int[] tmp: dict) {
                int nx = x + tmp[0] , ny = y + tmp[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)continue;
                if(grid[nx][ny] == 0)continue;
                if(ans[nx][ny])continue;
                ans[nx][ny] = true;
                d.addLast(new int[]{nx,ny});
            }
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "a";
        char c = str.charAt(0);
    }
}
