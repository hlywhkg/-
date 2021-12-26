import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/26 8:52
 * @Version 1.0
 */

class Solution {
    //给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
    //
    //对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/occurrences-after-bigram
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String>list = new ArrayList<String>();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1].equals(first)&& arr[i].equals(second)){
                if(i+1 < arr.length) {
                    list.add(arr[i+1]);
                }else {
                    break;
                }
            }
        }
        String []a = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str[] =solution.findOcurrences("alice is a good girl she is a good student","a","good");
        System.out.println(Arrays.toString(str));
    }
}
