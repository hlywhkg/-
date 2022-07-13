import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/13 20:03
 * @Version 1.0
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int x : asteroids) {
            boolean flg = true;
            while(!d.isEmpty() && d.peekLast() > 0 && x < 0 && flg){
                int a = d.peekLast(),b = -x;
                if(a >= b)flg = false;
                if(a <= b)d.pollLast();
            }
            if(flg)d.addLast(x);
        }
        int n =d.size();
        int[] ans = new int[n];
        while(!d.isEmpty()){
            ans[--n] = d.pollLast();
        }
        return ans;
    }
}

public class demo1 {
}
