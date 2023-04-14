import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/4/14 9:06
 * @Version 1.0
 */

import java.util.Scanner;
import java.util.*;

class Node {
    public int val;
    public Node next;
    public Node(int data) {
        this.val = data;
    }
}
public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Node head = new Node(in.nextInt());
            for (int i = 0; i < n - 1; i++) {
                head.next = new Node(in.nextInt());
            }
            int k = in.nextInt();
            Stack<Node> s = new Stack<>();
            Node cur = head, pre = null, next = null, newHead = head;
            while (cur != null) {
                next = cur.next;
                s.push(cur);
                if (s.size() == k) {
                    pre = reserve(s, pre, next);
                    newHead = newHead == head ? cur : newHead;
                }
                cur = next;
            }
            while (newHead != null) {
                System.out.print(newHead.val);
                newHead = newHead.next;
            }
        }
    }
    public static Node reserve(Stack<Node> s, Node left, Node right){
        Node cur = s.pop();
        if (left != null) {
            left.next = cur;
        }
        while (!s.isEmpty()) {
            Node next = s.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }


}
