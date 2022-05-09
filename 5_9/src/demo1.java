/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/9 17:48
 * @Version 1.0
 */


class Solution1 {
    public int[] diStringMatch(String s) {
        int[] arr = new int[s.length()+1];
        int min = 0, max = s.length(),index = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'I'){
                arr[index++] = min;
                min++;
            }else {
                arr[index++] = max;
                max--;
            }
        }
        arr[index] = min;
        return arr;
    }
}
public class demo1 {
    public static void main(String[] args) {

    }
}
