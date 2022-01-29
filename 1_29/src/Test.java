import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/29 14:11
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
class Solution3 {
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "abcdefg", k = 2
    //输出: "cdefgab"
    //
    //示例 2：
    //
    //输入: s = "lrloseumgh", k = 6
    //输出: "umghlrlose
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void reverseString(StringBuilder sb,int left,int right){
        while(left < right){
            char s = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,s);
            left++;
            right--;
        }
    }
    public String reverseLeftWords(String s, int n) {
        //①调用库函数
        // return s.substring(n) + s.substring(0,n);
        //②字符串拼接
        /*String res = "";
        for(int i = n;i < s.length();i++){
            res += s.charAt(i);
        }
        for(int i = 0; i < n; i ++){
            res += s.charAt(i);
        }
        return res;*/
        //③自己写反转字符串
        //先反转左边，在翻转右边，最后整体翻转
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        reverseString(sb,0,len-1);
        return sb.toString();
    }
}
class Solution2 {
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "We are happy."
    //输出："We%20are%20happy."
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    StringBuffer sb = new StringBuffer();
    public String replaceSpace(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){//计算空格
            sb.append(s.charAt(i));
            if(s.charAt(i) == ' '){
                count++;
            }
        }
        int new_length = sb.length() + 2 * count;//新长度
        int new_index = new_length - 1;//新长度的最后一个位置
        int old_index = sb.length() - 1;//旧长度的最后一个位置
        sb.setLength(new_length);
        while(new_index >= 0 && old_index >= 0){
            if(sb.charAt(old_index) == ' '){
                sb.setCharAt(new_index--,'0');
                sb.setCharAt(new_index--,'2');
                sb.setCharAt(new_index--,'%');
                --old_index;
            }else{
                sb.setCharAt(new_index--,sb.charAt(old_index));
                old_index--;
            }
        }
        return sb.toString();
    }
}
class Solution1 {
    //请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
    //
    //
    //
    //示例 1：
    //
    //输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
    //
    //示例 2：
    //
    //输入：head = [[1,1],[2,1]]
    //输出：[[1,1],[2,1]]
    //
    //示例 3：
    //
    //输入：head = [[3,null],[3,0],[3,null]]
    //输出：[[3,null],[3,0],[3,null]]
    //
    //示例 4：
    //
    //输入：head = []
    //输出：[]
    //解释：给定的链表为空（空指针），因此返回 null。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public Node copyRandomList(Node head) {
        Map<Node,Node>map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
public class Test {
    StringBuffer sb = new StringBuffer(19);
    Map<Integer,Integer>map = new Hashtable<>();

    public static void main(String[] args) {
        /*Node head = new Node(1);
        Map<Node,Node>map = new HashMap<>();
        while(head != null){
            map.put(cur,new Node);
            map.get
        }*/
        Test test1 = new Test();
        test1.map.put(1,2);
        System.out.println(test1.map.get(1));
    }
}
