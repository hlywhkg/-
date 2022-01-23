import javafx.scene.transform.Scale;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/23 15:11
 * @Version 1.0
 */

class StockPrice {
    //给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
    //
    //不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
    //
    //请你设计一个算法，实现：
    //
    //    更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
    //    找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
    //    找到当前记录里股票的 最高价格 。
    //    找到当前记录里股票的 最低价格 。
    //
    //请你实现 StockPrice 类：
    //
    //    StockPrice() 初始化对象，当前无股票价格记录。
    //    void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
    //    int current() 返回股票 最新价格 。
    //    int maximum() 返回股票 最高价格 。
    //    int minimum() 返回股票 最低价格 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/stock-price-fluctuation
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    Map<Integer,Integer> map;
    int cur = 0;
    int current[];
    PriorityQueue<int[]> maxHeap;
    PriorityQueue<int[]> minHeap;
    public StockPrice() {
        map = new HashMap<>();
        current = new int[]{-1,-1};
        maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    }

    public void update(int timestamp, int price) {
        if(timestamp >= current[0]){
            current = new int[]{timestamp,price};
        }
        cur = Math.max(cur,price);
        map.put(timestamp,price);
        maxHeap.offer(new int[]{timestamp, price});
        minHeap.offer(new int[]{timestamp, price});
    }

    public int current() {
        return current[1];
    }

    public int maximum() {
        while(! maxHeap.isEmpty() && maxHeap.peek()[1] != map.get(maxHeap.peek()[0])) {
            maxHeap.poll();
        }
        return maxHeap.peek()[1];
    }

    public int minimum() {
        while(! minHeap.isEmpty() && minHeap.peek()[1] != map.get(minHeap.peek()[0])) {
            minHeap.poll();
        }
        return minHeap.peek()[1];
    }
}
public class Test {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        scanner.nextLine();
        PriorityQueue<int[]> maxHeap;
        PriorityQueue<int[]> minHeap;
        maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    }
}
