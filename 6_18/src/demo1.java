/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/18 21:55
 * @Version 1.0
 */
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

class Solution {
    public Node insert(Node head, int insertVal) {
        Node ret = new Node(insertVal);
        ret.next = ret;
        if(head == null)return ret;
        int max = head.val,min = head.val;
        Node node = head;
        while(node.next != head){
            node = node.next;
            if(max < node.val){
                max = node.val;
            }
            if(min > node.val){
                min = node.val;
            }
        }
        if(max == min){
            ret.next = head.next;
            head.next = ret;
        }else{
            while(!(node.val == max && node.next.val == min))node = node.next;
            if(insertVal >= max || insertVal <= min){
                ret.next = node.next;
                node.next = ret;
            }else{
                while(!(node.val <= insertVal && node.next.val >= insertVal))node = node.next;
                ret.next = node.next;
                node.next = ret;
            }
        }
        return head;
    }
}

public class demo1 {
}
