import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/26 21:20
 * @Version 1.0
 */

public class HashBuck {
    public final double load_factor = 0.75;

    static int usedSize = 0;
    static class Node{
        int key;
        int val;

        Node next;

        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }
    Node[] hash ;
    public HashBuck(){
        this.hash = new Node[10];
    }

    public void put(int key , int val) {
        int index = key % hash.length;
        Node node = new Node(key, val);
        Node ret = hash[index];
        while (ret != null) {
            //覆盖重复元素
            if (ret.key == key) {
                ret.val = val;
            }
            ret = ret.next;
        }
        node.next = hash[index];
        hash[index] = node;
        usedSize++;

        if(loadFactor() >= load_factor){//负载因子超出限制，扩容
            resize();
        }
    }

    private void resize(){
        //2倍扩容
        int size = hash.length;
        Node cur[] = new Node[size * 2];
        //重新哈希
        for(int i = 0 ; i < size ; i++ ){
            Node ret = hash[i];
            while(ret != null){
                int index = ret.key % cur.length;
                //这个位置不止一个元素，采用头插法
                //先记录第二个元素防止丢失
                Node retNext = ret.next;

                ret.next = cur[index];
                cur[index] = ret;
                ret = retNext;
            }
        }
        hash = cur;
    }

    public int get(int key){
        int index = key % hash.length;
        Node ret = hash[index];
        while(ret != null){
            if(ret.key == key){
                return ret.val;
            }
            ret = ret.next;
        }
        return -1;
    }

    private double loadFactor(){
        return usedSize * 1.0 / hash.length;
    }

    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(12,12);
        hashBuck.put(3,3);
        hashBuck.put(4,4);
        hashBuck.put(2,2);
        hashBuck.put(6,6);
        //hashBuck.put(11,11);
        //hashBuck.put(8,8);
        System.out.println(hashBuck);
    }

}
