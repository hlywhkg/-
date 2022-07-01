import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/1 13:42
 * @Version 1.0
 */

class Solution2 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] move = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        Deque<int[]>d = new ArrayDeque<>();
        d.addLast(new int[]{row,col});
        while(!d.isEmpty()){
            int[] tmp = d.pollFirst();
            int x = tmp[0], y = tmp[1], cnt = 0;
            for (int[] ret : move) {
                int nx = x + ret[0],ny = y + ret[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)continue;
                if(grid[x][y] != grid[nx][ny])continue;
                else cnt++;
                if(ans[nx][ny] != 0)continue;
                d.addLast(new int[]{nx,ny});
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(ans[i][j] == 0){
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }
}

class Solution1 {
    char[] c;
    public List<Integer> diffWaysToCompute(String expression) {
        c = expression.toCharArray();
        return dfs(0,c.length - 1);
    }

    public List<Integer> dfs(int l , int r){
        List<Integer>ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if(c[i] >= '0' && c[i] <= '9')continue;
            List<Integer> l1 = dfs(l,i - 1),l2 = dfs(i + 1,r);
            for (int a : l1) {
                for (int b: l2) {
                    int val = 0;
                    if(c[i] == '+')val = a + b;
                    else if(c[i] == '-')val = a - b;
                    else if(c[i] == '*')val = a * b;
                    ans.add(val);
                }
            }
        }
        if(ans.isEmpty()){
            int val = 0;
            for (int i = l; i <= r; i++) {
                val = val * 10 + c[i] - '0';
            }
            ans.add(val);
        }
        return ans;
    }
}

public class demo1 {
}
