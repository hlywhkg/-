/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/23 21:22
 * @Version 1.0
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        sb = reverse(sb,0,n-1);
        //System.out.println(sb);
        sb = reverse(sb,n,len-1);
        //System.out.println(sb);
        sb = reverse(sb,0,len-1);
        //System.out.println(sb);
        return sb.toString();
    }
    public StringBuilder reverse(StringBuilder sb,int start,int end){
        while(start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
            start++;
            end--;
        }
        return sb;
    }
}

class Solution2 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            if(" ".equals(String.valueOf(s.charAt(i)))){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

class Solution1 {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        //将新创建的节点挂在每个源节点的后面，即1-2-3-》1-1`-2-2`-3-3`
        for(Node cur = head , copy = null; cur != null ; cur = cur.next.next){
            copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        //将random复制到节点
        for(Node cur = head ; cur != null ; cur = cur.next.next) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        //将链表分离为1-2-3 和 1`-2`-3`
        Node newHead = head.next;
        for(Node cur = head ,ret = null; cur != null && cur.next != null;) {
            ret = cur.next;
            cur.next = ret.next;
            cur = ret;
        }
        return newHead;
    }
}

public class demo1 {
    public static void main(String[] args) {
       Solution s = new Solution();
       String str = s.reverseLeftWords("abcdefg",2);
        System.out.println(str);
    }
}
