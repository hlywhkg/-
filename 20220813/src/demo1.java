import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/13 19:48
 * @Version 1.0
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> ans = new ArrayList();
        backTrack(list,ans,nums);
        return list;
    }
    public void backTrack(List<List<Integer>> list,List<Integer> ans , int[] num){
        if(ans.size() == num.length ){
            list.add(new ArrayList(ans));
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }

        for(int x : num){
            if(!ans.contains(x)){
                ans.add(x);
                backTrack(list,ans,num);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        /*String a="My field1";
        String b="My field1";
        String e = "My" + new String(" field1");
        String c=new String("My field1");
        String d=new String("My field1");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(c==d);
        System.out.println(a.equals(c));
        System.out.println(a == e);
        System.out.println(a.equals(e));
        System.out.println(e == d);
        System.out.println(e.equals(d));*/
        Solution s = new Solution();
        s.permute(new int[]{1,2,3});

    }
}
