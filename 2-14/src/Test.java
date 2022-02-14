import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/14 16:27
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution2 {
    // 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
    //数据范围：0≤k,n≤100000\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0≤val≤10000 \le val \le 1000 0≤val≤1000
    //要求：空间复杂度 O(n)O(n)O(n) ，时间复杂度 O(nlogn)O(nlogn)O(nlogn)
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(k,Collections.reverseOrder());
        for(int i = 0; i < input.length; i++){
            if(i < k){
                q.offer(input[i]);
            }else{
                if(input[i] < q.peek()){
                    q.poll();
                    q.offer(input[i]);
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll());
        }
        return list;
    }
}
class Solution1 {
    public void Swap(char []ch,int a,int b){
        char tmp = ch[a];
        ch[a] = ch[b];
        ch[b] = tmp;
    }
    public void Helper(ArrayList<String> list,char[] ch,int begin){
        if(begin == ch.length - 1){
            if(!list.contains(String.valueOf(ch))){
                list.add(new String(ch));
            }
            return;
        }
        for(int i = begin; i < ch.length; i++){
            Swap(ch,i,begin);
            Helper(list,ch,begin+1);
            Swap(ch,i,begin);
        }
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String>list = new ArrayList<>();
        if(str != null && str.length() > 0){
            Helper(list,str.toCharArray(),0);
            Collections.sort(list);
        }

        return list;
    }
}
public class Test {
    public static void main(String[] args) {
        //Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq = new PriorityQueue<>(2, Collections.reverseOrder());
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        while(pq.peek()!=null) {
            System.out.print(pq.poll() + " ");
        }
        pq.isEmpty();
    }
    public static void main1(String[] args) {
        String str = "1";
        char[]ch = str.toCharArray();
        String st = new String(ch);
        System.out.println(st);
    }
}
