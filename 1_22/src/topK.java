import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/23 11:35
 * @Version 1.0
 */

public class topK {
    public static int[] topK(int[] array,int k) {
        //1、创建一个大小为K的大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
       //2、遍历数组当中的元素，前K个元素放到队列当中
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
//3、从第k+1个元素开始，每个元素和堆顶元素进行比较
                int top = maxHeap.peek();
                if(top > array[i]) {
//3.1 先弹出
                    maxHeap.poll();
//3.2 后存入
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = maxHeap.poll();
        }
        return tmp;
    }
    /*public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });

    }*/
}
