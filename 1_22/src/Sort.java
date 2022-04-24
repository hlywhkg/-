import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/24 9:45
 * @Version 1.0
 */

public class Sort {
    /**
     * 其实就是一个直接插入排序
     * @param array 待排序序列
     * @param gap 组数
     */
    public static void shell(int[] array,int gap) {
        for (int i = 0; i < array.length - gap;i++) {
            int end = i;
            int tmp = array[end + gap];
            while (end >= 0) {
                if (array[end] > tmp) {
                    array[end + gap] = array[end];
                    end -= gap;
                } else {
                    break;
                }
            }
            array[end+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array,gap);
            gap /= 2;
        }
        shell(array,1);//保证最后是1组
    }

    /**
     * 选择排序
     * @param array 待排序序列
     */
    public static void selectSort(int[] array) {
        for(int i = 0;i < array.length - 1;i++){
            int min = i;
            for(int j = i + 1;j < array.length ;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(min != i){
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        int []arr= {1,2,6,2,7,9,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
