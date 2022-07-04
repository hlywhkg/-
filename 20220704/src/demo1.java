import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/4 15:45
 * @Version 1.0
 */


class Solution {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[]tmp : relation) {
            int a = tmp[0],b = tmp[1];
            Set<Integer> s = map.getOrDefault(a,new HashSet<>());
            s.add(b);
            map.put(a,s);
        }
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        while(!d.isEmpty() && k-- > 0){
            int size = d.size();
            while(size-- > 0){
                int poll = d.pollFirst();
                Set<Integer> ans = map.get(poll);
                if(ans == null)continue;
                for (int x : ans) {
                    d.addLast(x);
                }
            }
        }
        int count = 0;
        for (int x: d) {
            if(x == n - 1){
                count++;
            }
        }
        return count;
    }
}

class Solution2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>>list = new ArrayList<>();
        int n = arr.length,min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int x = arr[i] - arr[i-1];
            if(x < min){
                min = x;
            }
        }
        for (int i = 1; i < n; i++) {
            List<Integer>tmp = new ArrayList<>();
            if(arr[i] - arr[i-1] == min){
                tmp.add(arr[i]);
                tmp.add(arr[i-1]);
            }
            list.add(tmp);
        }
        return list;
    }
}

class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param input int整型一维数组
     * @param k int整型
     * @return int整型ArrayList
     */
    PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        if(k > input.length || k < 0)return new ArrayList<>();
        for (int x : input) {
            p.add(x);
            if(p.size() > k){
                p.poll();
            }
        }
       return new ArrayList<>(p);
    }
}

class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String cur = "";
        String ret = "";
        int i = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                cur = cur + c +  "";
            }else {
                if(cur.length() > ret.length()){
                    ret = cur;
                }else {
                    cur = "";
                }
            }
        }
        if(i == str.length() && cur.length() > ret.length()){
            ret = cur;
        }
        System.out.println(ret);
     }
}

public class demo1 {
    public static void main(String[] args) {
        /*PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        p.add(2);
        p.add(3);
        p.add(4);
        p.add(1);
        p.add(10);
        System.out.println(p);*/
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(1,4);
        System.out.println(map.get(1));
    }
}
