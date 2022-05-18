import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/18 11:41
 * @Version 1.0
 */
public class demo1 {
    private static Object locker = new Object();
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        Thread producer = new Thread(() -> {
            int num = 0;
            while(true) {
                try {
                    queue.put(num);
                    System.out.println("producer1生产了产品" + num + ",当前剩余产品数" + queue.size());
                    num++;
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();

        Thread consumer1 = new Thread(() -> {
            while(true){
                try {
                    int num = queue.take();
                    System.out.println("consumer1消费,当前剩余产品数" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer1.start();

        Thread consumer2 = new Thread(() -> {
            while(true){
                try {
                    int num = queue.take();
                    System.out.println("consumer1消费,当前剩余产品数" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer2.start();
    }
}
