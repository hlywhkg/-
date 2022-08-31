import com.sun.javafx.font.directwrite.DWFactory;

import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/31 15:23
 * @Version 1.0
 */

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)return 0;
        int reach = 0,nextReach = 0,step = 0;
        for(int i = 0 ; i < nums.length; i++) {
            //从起始到边界中的点下一步能到达的最远距离
            nextReach = Math.max(i+nums[i],nextReach);
            if(nextReach >= nums.length - 1)return (step+1);
            //如果到达了边界,说明这次走完了,将起始点更新为这次遍历寻找的下一步最远距离
            if(i == reach){
                step++;
                reach = nextReach;
            }
        }
        return step;
    }
}

class Solution2 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> d = new ArrayDeque<>();
        dfs(n,1,d,k);
        return list;
    }
    public void dfs(int target, int index, Deque<Integer> d,int k){
        if(target == 0 && d.size() == k){
            list.add(new ArrayList<>(d));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if(target - i < 0)return;
            d.addLast(i);
            dfs(target,index+1,d,k);
            d.removeLast();
        }
    }
}

class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int x : nums) {
            p.add(x);
            if(p.size() > k){
                p.poll();
            }
        }
        return p.peek() == null ? -1 : p.peek();
    }
}

public class demo1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0 ; i < 10 ; i++){
            p.add(i);
            if(p.size() > 5){
                p.poll();
            }
        }
        for (int x : p) {
            System.out.println(x);
        }
    }
}
