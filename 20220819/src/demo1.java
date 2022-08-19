/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/19 13:18
 * @Version 1.0
 */

class Solution2 {
    //归并排序
    public static int mod = 1000000007;
    public static int num = 0;
    public int InversePairs(int [] array) {
        int n = array.length;
        int[] tmp = new int[n];
        MergeSort(array,0,n-1,tmp);
        return num;
    }
    public void MergeSort(int[] arr,int left,int right,int[]tmp){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        MergeSort(arr,left,mid,tmp);
        MergeSort(arr,mid+1,right,tmp);
        Merge(arr,left,mid,right,tmp);
    }
    public void Merge(int[] arr,int left,int mid,int right,int[]tmp){
        int begin1 = left,end1 = mid,begin2 = mid + 1,end2 = right,t = left;
        while(begin1 <= end1 && begin2 <= end2){
            if(arr[begin1] <= arr[begin2]){
                tmp[t++] = arr[begin1++];
            }else{
                tmp[t++] = arr[begin2++];
                num = (num + mid - begin1 + 1) % mod;
            }
        }
        while(begin1 <= end1){
            tmp[t++] = arr[begin1++];
        }
        while(begin2 <= end2){
            tmp[t++] = arr[begin2++];
        }
        for(int i = left ; i <= right ; i++){
            arr[i] = tmp[i];
        }
    }
}


class Solution1 {
    //二分查找
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

public class demo1 {
}
