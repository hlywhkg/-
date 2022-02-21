/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/21 19:13
 * @Version 1.0
 */
import java.util.*;


class Solution {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public boolean isReverser(String s,int first,int end){
        while(first < end){
            if(s.charAt(first) == s.charAt(end)){
                first++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public int minCut (String s) {
        // write code here
        int len = s.length();
        if(isReverser(s,0,len - 1))return 0;
        int dp[] = new int[len + 1];
        //整体初始化
        for(int i = 1 ; i <= len ; i++) {
            dp[i] = i - 1;
        }
        for(int i = 2 ; i <= len ; i++){
            //数组下标为0没有用到，这里的 i代表下标，因此 i-1代表前i个字符
            //判断前 i 个字符是否是回文，是则更新为 0
            if(isReverser(s,0,i - 1)){
                dp[i] = 0;
                continue;
            }
            //如果不是判断前面的是否是回文串，并与现在得到dp[i]相比
            for(int j = 1 ; j < i ; j++){
                if(isReverser(s,j,i - 1)){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len];
    }
}
public class Test {
}
