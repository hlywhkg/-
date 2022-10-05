/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/10/5 23:06
 * @Version 1.0
 */

public class Solution {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return find(a,0,n-1,n-K);
    }
    public int find(int[] a,int begin,int end,int index){
        int pivot = a[begin];
        int i = begin,j = end;
        while(i < j){
            while(i < j && a[j] >= pivot){
                j--;
            }
            while(i < j && a[i] <= pivot){
                i++;
            }
            if(i < j){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[begin] = a[j];
        a[j] = pivot;
        if (j == index) {
            return a[j];
        }else if (j > index){
            return find(a,begin,j-1,index);
        }else {
            return find(a,j+1,end,index);
        }
    }
}
