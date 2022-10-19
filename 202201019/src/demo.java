/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/19 22:45
 * @Version 1.0
 */

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int tmp = 0;
        for(int num : array){
            tmp ^= num;
        }
        int ret = 1;
        while((tmp&ret) == 0){
            ret <<= 1;
        }
        int a = 0 , b = 0;
        for(int num : array) {
            if((num&ret)== 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        if(a > b){
            int d = a;
            a = b;
            b = d;
        }
        return new int[]{a,b};
    }
}

public class demo {
}
