import java.util.Arrays;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/12 10:51
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) {
        int arr[] = {10,101,3,4,5,7,5,6,8};
        arr = Arrays.copyOf(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr[3] = arr[4];
    }
}
