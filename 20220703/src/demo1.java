import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/3 19:43
 * @Version 1.0
 */

class Solution {
    int ret = (int)1e6,max = (int)1e5;
    long P = 131l;
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    Set<Long> s = new HashSet<>();
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        for (int[]p : blocked) {
            s.add(p[0] * P + p[1]);
        }
        max = n * (n -1) / 2;
        return check(source,target) && check(target,source);
    }

    public boolean check(int[]a ,int[]b){
        Set<Long> vis = new HashSet<>();
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(a);
        vis.add(a[0] * P + a[1]);
        while (!d.isEmpty() && vis.size() <= max) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            if (x == b[0] && y == b[1]) return true;
            for (int[] di : dir) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= ret || ny < 0 || ny >= ret) continue;
                long hash = nx * P + ny;
                if (s.contains(hash)) continue;
                if (vis.contains(hash)) continue;
                d.addLast(new int[]{nx, ny});
                vis.add(hash);
            }
        }
        return vis.size() > max;
    }
}

class Solution1 {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            int x = n % 10;
            list.add(x);
            n /= 10;
        }
        int s = list.size(),index = -1;
        for (int i = 0; i < s - 1 && index == - 1; i++) {
            if(list.get(i+1) < list.get(i))index = i + 1;
        }
        if(index == -1)return -1;
        for (int i = 0; i < index; i++) {
            if(list.get(i) > list.get(index)){
                swap(list,i,index);
                break;
            }
        }
        for (int l = 0 ,r = index - 1; l < r; l++ , r--) {
            swap(list,l,r);
        }
        long ans = 0;
        for (int i = s - 1; i >= 0; i--) {
            ans = ans * 10 + list.get(i);
        }
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }
    public void swap(List<Integer>list , int x , int y) {
        int tmp = list.get(x);
        list.set(x,list.get(y));
        list.set(y,tmp);
    }
}

public class demo1 {
    public static void main(String[] args) {
        int x = 104;
        System.out.println(x % 10);

        System.out.println(x);
        x /= 10;
        System.out.println(x);
    }
}
