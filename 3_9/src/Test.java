import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/9 20:41
 * @Version 1.0
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //lambda表达式按照数组 1 下标从小到大进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int num = 1, i = 0;
        for (int j = 1; j < intervals.length; j++)
        {
            if (intervals[j][0] >= intervals[i][1])
            {
                i = j;
                num++;
            }
        }
        return intervals.length - num;
    }
}
class test {
    public static int find(int[][] arr) {
        //lambda表达式按照数组 1 下标从小到大进行排序
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
        int num = 1, i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j][0] >= arr[i][1]) {
                i = j;
                num++;
            }
        }
        return arr.length - num;
    }
}
public class Test {

    public static void main(String[] args) {
        int [][]arr = {{2,3},{3,4},{1,2},{53,0},{6,40},{34,5},{3,5}};
        Arrays.sort(arr,(o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
