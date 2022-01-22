/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/22 9:02
 * @Version 1.0
 */

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     * 向下调整函数的实现
     * @param parent 每棵树的根节点
     * @param len 每棵树的调整的结束位置  10
     */
    public void shiftDown(int parent,int len) {
        int child = 2*parent+1;
        //1、最起码 是有左孩子的，至少有1个孩子
        while (child < len) {
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;//保证当前左右孩子最大值的下标
            }else {
                if(elem[child] > elem[parent]){
                    int tmp = elem[parent];
                    elem[parent] = elem[child];
                    elem[child] = tmp;
                    parent = child;
                    child = parent * 2 + 1;
                }else {
                    break;
                }
            }
        }
    }

    public int pop(){
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        usedSize--;
        shiftDown(0,usedSize);
        return tmp;
    }

    public int peek(){
        int tmp = elem[0];
        return tmp;
    }

    public boolean isEmpty(){
        return usedSize == 0;
    }

    public boolean isFull(){
        return usedSize > elem.length;
    }

    public void createHeap(int[] array) {//建大堆
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
            //调整
            shiftDown(parent,usedSize);
        }
    }
    //有一堆石头，每块石头的重量都是正整数。
    //
    //每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
    //
    //    如果 x == y，那么两块石头都会被完全粉碎；
    //    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    //
    //最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
    //
    //
    //
    //示例：
    //
    //输入：[2,7,4,1,8,1]
    //输出：1
    //解释：
    //先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
    //再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
    //接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
    //最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/last-stone-weight
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int lastStoneWeight(int[] stones) {
        this.elem = new int[stones.length];
        createHeap(stones);
        for(int i = 0;i <= usedSize;i++){
            int x = elem[0];
            elem[0] = 0;
            shiftDown(0,usedSize);
            elem[0] = x - elem[0];
            shiftDown(0,usedSize);
        }
        return elem[0];
    }

}
