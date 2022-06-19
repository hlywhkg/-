import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/19 20:11
 * @Version 1.0
 */
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
    Map<Integer,Integer> map = new HashMap<>();
    int max;

    public int[] findFrequentTreeSum(BTNode root) {
        dfs(root);
        List<Integer> list = new LinkedList<>();
        for (int x : map.keySet()) {
            if(map.get(x) == max)list.add(x);
        }
        int size = list.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int dfs(BTNode head){
        if(head == null)return 0;
        int val = head.val + dfs(head.left) + dfs(head.right);
        map.put(val,map.getOrDefault(val,0)+1);
        max = Math.max(max,map.get(val));
        return val;
    }
}

public class demo1 {
}
