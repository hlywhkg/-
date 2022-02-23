/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/23 14:28
 * @Version 1.0
 */
import java.util.*;

import java.util.*;


class Solution2 {
    /**
     *
     * @param S string字符串
     * @param T string字符串
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        // write code here
        int len1 = S.length(),len2 = T.length();
        int dp[][] = new int[len1+1][len2+1];
        dp[0][0] = 1;
        for(int i = 1; i <= len1 ; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j <= len2 ; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                //下标 i-1,实际是第 i 个字符
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
class Solution1 {
    /**
     *
     * @param word1 string字符串
     * @param word2 string字符串
     * @return int整型
     */
    public int minDistance (String word1, String word2) {
        // write code here
        int len1 = word1.length(),len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for(int i = 1 ; i <= len1 ; i++){
            dp[i][0] = i;
        }
        for(int j = 1 ; j <= len2 ; j++){
            dp[0][j] = j;
        }
        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
public class Test {
}
