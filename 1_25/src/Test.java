/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/25 8:55
 * @Version 1.0
 */

public class Test {
    /**
     *
     * @param array1 有序的
     * @param array2 有序的
     * @return
     */
    public static int[] mergeArray(int[] array1,int[] array2) {
        int []arr = new int[array1.length+ array2.length];
        int size1 = array1.length -1,size2 = array2.length-1;
        int count1 = 0,count2 = 0,count = 0;
        while(size1 > 0 && size2 > 0){
            if(array1[count1] < array2[count2]){
                arr[count++] = array1[count1++];
                size1--;
            }else{
                arr[count++] = array2[count2++];
                size2--;
            }
        }
        while(size1 > 0){
            arr[count++] = array1[count1++];
            size1--;
        }
        while(size2 > 0){
            arr[count++] = array2[count2++];
            size2--;
        }
        return arr;
    }
}
