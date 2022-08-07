import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/7 21:12
 * @Version 1.0
 */

class Solution {
    List<List<Integer>> list;
    List<Integer> ret;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        ret = new ArrayList<>();
        dfs(1,n,k);
        System.out.println(list);
        return list;
    }
    public void dfs(int i,int n,int k){
        if(ret.size() == k){
            list.add(new ArrayList<>(ret));
            return;
        }
        for(int j = i ; j <= n ; j++){
            ret.add(j);
            dfs(j+1,n,k);
            ret.remove(ret.size()-1);
        }
    }
}

class Solution1 {
    List<List<Integer>> list;
    List<Integer> ret;
    int[] nums;
    int n;
    public List<List<Integer>> subsets(int[] _nums) {
        nums = _nums;
        list = new ArrayList<>();
        n = nums.length;
        ret = new ArrayList<>();
        dfs(0);
        return list;
    }

    public void dfs(int index){
        if(index == n){
            list.add(new ArrayList<>(ret));
            return;
        }
        ret.add(nums[index]);
        dfs(index+1);
        ret.remove(ret.size()-1);
        dfs(index+1);
    }
}


public class demo1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4,2));
    }
}
