import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/30 19:05
 * @Version 1.0
 */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
        //
        //给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/hand-of-straights
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        if(hand.length % groupSize !=0)return false;
        Map<Integer,Integer>hash = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x: hand) {
            hash.put(x,hash.getOrDefault(x,0)+1);
            heap.offer(x);
        }
        while(!heap.isEmpty()){
            int card = heap.poll();//取堆顶第一个元素，是最小的元素
            if(hash.containsKey(card)){
                //从这个元素开始，看是否是顺子，不是直接返回false
                for (int i = 0; i < groupSize; i++) {
                   int card2 = card + i;
                    if(!hash.containsKey(card2)){
                        return false;
                    }else {
                        //如果该元素只有一个了，直接删除
                        if(hash.get(card2) == 1){
                            hash.remove(card2);
                            //如果还有多次，给这个元素的数量减一
                        }else {
                            hash.put(card,hash.get(card)-1);
                        }
                    }
                }
            }
        }
        return true;
    }
}
public class Test {

}
