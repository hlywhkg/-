import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/10 20:35
 * @Version 1.0
 */

class BTNode {
    int val;
    BTNode left;
    BTNode right;

    BTNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> distanceK(BTNode root, BTNode target, int k) {
        Map<BTNode,Integer> map = new HashMap<>();
        Map<BTNode,Integer> ret = new HashMap<>();
        Deque<BTNode> d = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        d.addLast(root);
        int count = 0,index = 0;
        while(d.isEmpty()){
            int size = d.size();
            while(size-- > 0){
                BTNode tmp = d.pollFirst();
                if(tmp == target){
                    index = count;
                }
                map.put(tmp,count);
                ret.put(tmp,tmp.val);
                if(tmp.left != null)d.addLast(tmp.left);
                if(tmp.right != null)d.addLast(tmp.right);
            }
            count++;
        }
        int x = index + k,y = Math.abs(index - k);
        BTNode b = root;
        while(b != null){
            if(map.get(b) == x || map.get(b) == y){
                ans.add(ret.get(b));
            }
        }
        return ans;
    }
}

public class demo1 {
}
