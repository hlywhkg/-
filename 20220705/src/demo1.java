import java.sql.Struct;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/5 9:51
 * @Version 1.0
 */

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length,n = isWater[0].length;
        Deque<int[]> d = new ArrayDeque<>();
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j] == 1)d.addLast(new int[]{i,j});
                ans[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }
        int[][]dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!d.isEmpty()){
            int[] tmp = d.pollFirst();
            int x = tmp[0],y = tmp[1];
            for (int[] ret : dirs) {
                int nx = x + ret[0],ny = y + ret[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)continue;
                if(ans[nx][ny] != -1)continue;
                ans[nx][ny] = ans[x][y] + 1;
                d.addLast(new int[]{nx,ny});
            }
        }
        return ans;
    }
}

class MyCalendar {

    class Node{

        /**
         * l ,r 代表在数组中的下标
         * add是懒标记
         * val代表此节点拥有的多少数
         */

        int l,r,add,val;

    }

    int N = (int)1e9,M = 120010,cnt = 1;
    Node[] arr = new Node[M];

    /**
     * 动态开点
     */
    public void create(int v){
        if(arr[v] == null)arr[v] = new Node();
        if(arr[v].l == 0){
            arr[v].l = ++cnt;
            arr[arr[v].l] = new Node();
        }
        if(arr[v].r == 0){
            arr[v].r = ++cnt;
            arr[arr[v].r] = new Node();
        }
    }

    /**
     * 传递懒标记,通过懒标记更新下面的值,随后清除父节点懒标记
     * @param v
     * @param len
     */
    public void pushDown(int v,int len){
        arr[arr[v].l].add += arr[v].add;
        arr[arr[v].r].add += arr[v].add;
        arr[arr[v].l].val += (len - len / 2) * arr[v].add;
        arr[arr[v].r].val += (len / 2) * arr[v].add;
        arr[v].add = 0;
    }

    /**
     * 通过下面已更新的值重新更新上面的值
     * @param u
     */
    public void pushUp(int u){
        arr[u].val = arr[arr[u].l].val + arr[arr[u].r].val;
    }

    /**
     *
     * @param v
     * @param l 数组左边界
     * @param r 数组右边界
     * @param lc 要查询的左边界
     * @param lr 要查询的右边界
     */
    public int query(int v , int l , int r , int lc , int lr){
        if(lc <= l && r <= lr)return arr[v].val;
        create(v);
        pushDown(v,r - l + 1);
        int mid = l + r >> 1,ans = 0;
        if(lc <= mid)ans = query(arr[v].l,l,mid,lc,lr);
        if(lr > mid)ans += query(arr[v].r,mid + 1,r,lc,lr);
        return ans;
    }

    /**
     * 插数，创建懒标记
     * @param v
     */
    public void update(int v , int l , int r , int lc , int lr,int u){
        if(lc <= l && r <= lr){
            arr[v].val += (r - l + 1) * u;
            arr[v].add += u;
            return ;
        }
        create(v);
        pushDown(v,r - l + 1);
        int mid = l + r >> 1;
        if(lc <= mid)update(arr[v].l,l,mid,lc,lr,u);
        if(lr > mid)update(arr[v].r,mid + 1,r,lc,lr,u);
        pushUp(v);
    }

    public boolean book(int start, int end) {
        if(query(1,1,N + 1,start + 1,end) > 0)return false;
        update(1,1,N+1,start+1,end,1);
        return true;
    }
}

public class demo1 {
}
