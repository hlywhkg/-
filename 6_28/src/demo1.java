/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/28 18:18
 * @Version 1.0
 */

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flg = false;
            for (int[]arr : ranges ) {
                int l = arr[0],r = arr[1];
                if(i >= l && i <= r)flg = true;
            }
            if(!flg)return false;
        }
        return true;
    }
}

class Solution1 {
    int[] arr;
    int n;
    int qselect(int l, int r, int k) {
        if (l == r) return arr[l];
        int x = arr[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(l, j, k);
        else return qselect(j + 1, r, k - cnt);
    }
    void swap(int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
    int getIdx(int x) {
        return (2 * x + 1) % (n | 1);
    }
    public void wiggleSort(int[] nums) {
        arr = nums;
        n = nums.length;
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        while (loc <= r) {
            if (arr[getIdx(loc)] > x) swap(getIdx(loc++), getIdx(l++));
            else if (arr[getIdx(loc)] < x) swap(getIdx(loc), getIdx(r--));
            else loc++;
        }
    }
}

public class demo1 {
    public static void main(String[] args) {
        int i = 0;
        while(i < 5){
            do i++;
            while(i<10);
            System.out.println(i);
        }
       // System.out.println(i);
    }
}
