import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/24 15:56
 * @Version 1.0
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 1; i <= n; i++) {
            int x = sum[i],y = target - x;
            int l = 0 , r = i;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(sum[mid] <= y)l = mid;
                else r = mid - 1;
            }
            if(sum[r] <= y)ans = Math.min(ans,i - r);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

class BTNode {
    int val;
    BTNode left;
    BTNode right;

    BTNode() {
    }

    BTNode(int val) {
        this.val = val;
    }

    BTNode(int val, BTNode left, BTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> largestValues(BTNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<BTNode> ans = new ArrayDeque<>();
        ans.addLast(root);
        while(!ans.isEmpty()){
            int size = ans.size(),max = ans.peek().val;
            while(size-- > 0){
                BTNode ret = ans.pollFirst();
                max = Math.max(max,ret.val);
                if(ret.left != null)ans.addLast(ret.left);
                if(ret.right != null)ans.addLast(ret.right);
            }
            list.add(max);
        }
        return list;
    }
}

public class demo1 {
}
