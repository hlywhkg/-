import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/30 15:24
 * @Version 1.0
 */
class Solution4 {
    public int[] count(String word){
        int count[] = new int[26];
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            count[c-'a']++;
        }
        return count;
    }
    public boolean isOk(int s[],int t[]){
        for(int i = 0; i < 26; i++){
            if(s[i] > t[i]){
                return false;
            }
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int []word = count(chars);
        int ret = 0;
        for(String str :words){
            int[] arr = count(str);
            if(isOk(arr,word)){
                ret += str.length();
            }
        }
        return ret;
    }
}
class Solution3 {
    //还是二分，面试查找基本都是二分
    public int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + ( right - left ) / 2;
            if(nums[mid] == mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
class Solution2 {
    //统计一个数字在排序数组中出现的次数。
    //二分查找妙用找一个数重复次数，目标的右边界减去目标数减一的右边界
    public int midSearch(int[]nums,int target){
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + ( right - left ) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
    public int search(int[] nums, int target) {
        return midSearch(nums,target) - midSearch(nums,target-1);
    }
}
class Solution1 {
    //找重复数字中的任意一个
    public int findRepeatNumber(int[] nums) {
        //①哈希表记录时间O(n)空间O(n)
        /*Map<Integer,Integer>map = new Hashtable<>();
        for (int x:nums) {
            if(!map.containsKey(x)){
                map.put(x,x);
            }else{
                return x;
            }
        }
        return 0;*/
        //②数组记录时间O(n)空间O(1)
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == i){
                continue;
            }
            if(nums[nums[i]] == nums[i])return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return 0;
    }
}
public class Test {
    Test test = new Test();
    public static int fun(){
        test.func();
        return 1;
    }
    public void func(){
        System.out.println(1);
    }
    public static void main(String[] args) {
        Test test = new Test();
    }
}
