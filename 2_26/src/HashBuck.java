/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/26 21:20
 * @Version 1.0
 */

public class HashBuck {
    public final double load_factor = 0.75;
    Node hash[] = new Node[8];
    static int usedSize = 0;
    class Node{
        int key;
        int val;

        Node next;

        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(int key , int val){
        int index = key % hash.length;
        Node node = new Node(key,val);
        Node ret = hash[index];
        while(ret != null){
            if(ret.key == key){
                ret.val = val;
            }
            ret = ret.next;
        }
        if(hash[index] == null){
            hash[index] = node;
        }else{
            Node cur = hash[index];
            node.next = cur;
            node = hash[index];
        }
    }




}
