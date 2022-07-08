/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/8 9:36
 * @Version 1.0
 */

import java.util.*;


class Solution {
    String s, e;
    Set<String> set = new HashSet<>();
    public int ladderLength(String _s, String _e, List<String> ws) {
        s = _s;
        e = _e;
        for (String w : ws) set.add(w);
        if (!set.contains(e)) return 0;
        int ans = bfs();
        return ans == -1 ? 0 : ans + 1;
    }

    int bfs() {
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque();
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) return t;
        }
        return -1;
    }
    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size();
        while (m-- > 0) {
            String poll = deque.pollFirst();
            int n = poll.length();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    String sub = poll.substring(0, i) + String.valueOf((char)('a' + j)) + poll.substring(i + 1);
                    if (set.contains(sub)) {
                        if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) continue;
                        if (other.containsKey(sub)) {
                            return cur.get(poll) + 1 + other.get(sub);
                        } else {
                            deque.addLast(sub);
                            cur.put(sub, cur.get(poll) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }
}



class Solution1 {
    int[] nums;
    public int minimumOperations(int[] _nums, int start, int goal) {
        nums = _nums;
        Deque<Long> d1 = new ArrayDeque<>(),d2 = new ArrayDeque<>();
        Map<Long,Integer> m1 = new HashMap<>(),m2 = new HashMap<>();
        d1.addLast(start * 1l);d2.addLast(goal * 1l);
        m1.put(start * 1l,0);m2.put(goal * 1l,0);
        while(!d1.isEmpty() && !d2.isEmpty()){
            if(d1.size() < d2.size()){
                int ans = update(m1,d1,m2,d2,true);
                if(ans != -1)return ans;
            }else {
                int ans = update(m2,d2,m1,d1,false);
                if(ans != -1)return ans;
            }
        }
        return -1;
    }

    private int update(Map<Long, Integer> m1, Deque<Long> d1, Map<Long, Integer> m2, Deque<Long> d2, boolean flg) {
        int size = d1.size();
        while(size-- > 0){
            long cur = d1.pollFirst();
            int steps = m1.get(cur);
            for (int x : nums) {
                if(flg){
                    if(cur >= 0 && cur <= 1000){
                        long[] arr = new long[]{cur + x,cur - x , cur ^ x};
                        for (long y : arr) {
                            if(m2.containsKey(y))return m2.get(y) + steps + 1;
                            else {
                                if(m1.containsKey(y))continue;
                                else {
                                    d1.addLast(y);
                                    m1.put(y,steps+1);
                                }
                            }
                        }
                    }
                }else {
                    long[] arr = new long[]{cur + x,cur - x , cur ^ x};
                    for (long y : arr) {
                        if(y >= 0 && y <= 1000){
                            if(m2.containsKey(y))return m2.get(y) + steps + 1;
                            else {
                                if(m1.containsKey(y))continue;
                                else{
                                    d1.addLast(y);
                                    m1.put(y,steps + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static int GetLen(String s){
        int n = s.length();
        if(n <= 4)return 5;
        else if(n >= 5 && n <= 7)return 10;
        else return 25;
    }

    public static int GetPhra(String s){
        char[] c = s.toCharArray();
        int low = 0 , up = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a >= 65 && a <= 90){
                low++;
            }else if(a >= 97 && a <= 122){
                up++;
            }
        }
        if(low == 0 && up == 0)return 5;
        else if(low > 0 && up == 0 || low == 0 && up > 0)return 10;
        else return 20;
    }

    public static int GetNu(String s){
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            if(a >= 0 && a <= 9){
                count++;
            }
        }
        if (count == 0)return 5;
        else if(count == 1)return 10;
        else return 20;
    }

    public static int GetF(String s){
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            if(!(a >= 65 && a <= 90 || a >= 97 && a <= 122)){
                count++;
            }
        }
        if(count == 0)return 5;
        else if(count == 1)return 10;
        else return 25;
    }

    public static int GetP(String s){
        int a = GetNu(s),b = GetPhra(s),c = GetF(s);
        if(b == 20 && a >= 10 && c >= 10)return 5;
        else if(b == 10 && a >= 10 && c >= 10)return 3;
        else return 2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int sum = GetF(str) + GetP(str) + GetNu(str) + GetLen(str) + GetPhra(str);
            if(sum >= 90) System.out.println("VERY_SECURE");
            else if(sum >= 80) System.out.println("SECURE");
            else if(sum >= 70) System.out.println("VERY_STRONG");
            else if(sum >= 60) System.out.println("STRONG");
            else if(sum >= 50) System.out.println("AVERAGE");
            else if(sum >= 25) System.out.println("WEAK");
            else System.out.println("VERY_WEAK");
        }
    }
}

public class deno1 {
    public static void main(String[] args) {
        String regex = "[^a-z]";
        String str = "ad1314geq";
        String ret = str.replaceAll(regex,str);
        System.out.println(ret);
        Map<Integer,Integer> map = new HashMap<>();
    }
}
