import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/17 19:32
 * @Version 1.0
 */
class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int ret = array[0];
        for(int i = 1 ; i < array.length ; i++) {
            if(count == 0){
                count = 1;
                ret = array[i];
            }else{
                if(array[i] == ret){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == ret){
                count++;
            }
        }
        return count * 2 > array.length ? ret : 0;
    }
}
class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int max = 0;
        int count = 0;
        int end = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                count++;
                if(max < count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        String tmp = str.substring(end - max + 1, end + 1);
        System.out.println(tmp);
    }
}
public class test {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        map.getOrDefault('c',10);
        System.out.println(map.get('a'));
    }
}
