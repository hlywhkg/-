/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/19 16:53
 * @Version 1.0
 */
package demo1;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public Node root = null;


    public Node search(int key) {
        Node cur = root;
        while(cur != null){
            if(cur.val < key){
                if(cur.right != null){
                    cur = cur.right;
                }
            }else if(cur.val > key){
                if(cur.left != null){
                    cur = cur.left;
                }
            }else{
                return cur;
            }
        }
        return null;
    }
    public boolean insert(int val) {
        if(root == null) {
            root = new Node(val);
            return true;
        }
        Node cur = root;
        Node p = null;
        while(cur != null){
            p = cur;
            if(cur.val > val){
                cur = cur.left;
            }else if (cur.val < val){
                cur = cur.right;
            }else{
                return false;
            }
        }
        if(p.val > val){
            p.left = new Node(val);
        }else{
            p.right = new Node(val);
        }
        return true;
    }
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                //这里开始删除
                removeNode(cur,parent);
                break;
            }else if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(Node cur,Node parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            parent = cur;
            cur = cur.right;
            if(cur.left != null){
                if(cur.left != null) {
                    cur.val = cur.left.val;
                    cur.left = null;
                }else if(cur.right != null){
                    cur.val = cur.right.val;
                    cur.right = null;
                }
            }else if(cur.left != null){
                if(cur.left.right != null){
                    cur.val = cur.left.right.val;
                }else if(cur.left.left != null){
                    cur.val = cur.left.left.val;
                }
            }else{
                return;
            }
        }
    }

}