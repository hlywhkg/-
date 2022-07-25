import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/25 15:49
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

class CBTInserter {
    List<BTNode> list = new ArrayList<>();
    int idx = 0;
    public CBTInserter(BTNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            BTNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }
    public int insert(int val) {
        BTNode node = new BTNode(val);
        while (list.get(idx).left != null && list.get(idx).right != null) idx++;
        BTNode fa = list.get(idx);
        if (fa.left == null) fa.left = node;
        else if (fa.right == null) fa.right = node;
        list.add(node);
        return fa.val;
    }
    public BTNode get_root() {
        return list.get(0);
    }
}


public class demo1 {
    public static void main(String[] args) {

    }
}
