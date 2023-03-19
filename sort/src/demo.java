import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2023/3/18 17:12
 * @Version 1.0
 */




public class demo {

    /**
     *   冒泡排序
     */
    public static int[] sort1(int[] array){
        for(int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < i; j++) {
                if(array[i] < array[j]) {
                    swap(array,i,j);
                }
            }
        }
        return array;
    }

    /**
     *  插入排序
     *  时间复杂度O(N^2)
     *  最好，O(N),有序
     *  稳定
     */
    public static int[] sort2(int[] array) {
        //默认第一个数是有序的，所以下标从1开始
        for(int i = 1; i < array.length ; i++) {
            //将新插进来的数保存起来，那么它前面的数都是有序的了
            //所以只需与前面的数比较大小
            int tmp = array[i];
            int j = i-1;
            for(; j >=0 ; j--) {
                if(tmp > array[j]) {
                    break;
                }else {
                    array[j+1] = array[j];
                }
            }
            //当下标减为-1时，也就是插入的是当前数组最小元素，需要重新赋值
            //当然这里写了循环中的判断里面没必要再写一遍
            array[j+1] = tmp;
        }
        return array;
    }

    /**
     * 希尔排序
     * 时间复杂度O(N^1.3~N^1.5)
     * 不稳定
     */
    public static int[] sort3(int[] array) {
        int gap = array.length;
        while(gap >= 1) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                for (; j >= 0 ; j-=gap) {
                    if(array[j] > tmp) {
                        array[j+gap] = array[j];
                    }else {
                        break;
                    }
                }
                array[j+gap] = tmp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     *  选择排序
     *  不稳定
     *  O(N^2)
     */
    public static int[] sort4(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                int tmp = array[i];
                if(tmp > array[j]) {
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     *
     * 堆排序
     *
     */
    public static int[] sort5(int[] array){
        //建堆
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjust(array,i);
        }
        int length = array.length - 1 ;
        while(length > 0) {
            swap(array,0,length);
            //length--;
            adjust(array,0);
            length--;
        }
        return array;
    }
    public static void adjust(int[]array,int parent) {
        int child = parent * 2 + 1;
        while(child < array.length) {
            //找出子节点中较大的一个
            if(child+1 < array.length && array[child] < array[child+1]) {
                child += 1;
            }else {
                if(array[child] > array[parent]) {
                    swap(array,child,parent);
                    parent = child;
                    child = parent * 2 + 1;
                }else {
                    break;
                }
            }
        }
    }




    public static void test1(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        long begin = System.currentTimeMillis();
        //sort1(array);
        sort2(array);
        //sort3(array);
        //sort4(array);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
    public static void test2(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long begin = System.currentTimeMillis();
        //sort1(array);
        sort2(array);
        //sort3(array);
        //sort4(array);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void swap(int[] arr,int i ,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4,3,2,5,7};
        //array = sort1(array);
        //array = sort2(array);
        //array = sort3(array);
        //array = sort4(array);
        array = sort5(array);
        System.out.println(Arrays.toString(array));
        //test1(10_0000);
        //test2(10_0000);
    }
}
