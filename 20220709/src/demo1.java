import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/9 9:13
 * @Version 1.0
 */


class Solution {
    int[][] g;
    int n;
    List<List<Integer>> list;
    List<Integer> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        list = new ArrayList<>();
        ans = new ArrayList<>();
        ans.add(0);
        dfs(0);
        return list;
    }
    public void dfs(int x){
        if(x == n - 1){
            list.add(new ArrayList<>(ans));
            return ;
        }
        for (int next : g[x]) {
            ans.add(next);
            dfs(next);
            ans.remove(ans.size() - 1);
        }
    }
}

class Solution1 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length,ans = 0;
        for (int i = 0; i < n; i++) {
            //存储各个数的下标
            map.put(arr[i],i);
        }
        //dp[j][i]代表以i下标值作为斐波那契的最后一个数字，j下标值作为倒数第二个值
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > ans ; j--) {
                if(arr[i] - arr[j] >= arr[j])break;
                int t = map.getOrDefault(arr[i] - arr[j],-1);
                if(t == -1)continue;
                dp[j][i] = Math.max(3,dp[t][j] + 1);
                ans = Math.max(ans,dp[j][i]);
            }
        }
        return ans;
    }
}

public class demo1 {
    public static void main(String[] args) {
       // Integer.MAX_VALUE
    }
}
