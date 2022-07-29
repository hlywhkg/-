import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/17 8:56
 * @Version 1.0
 */

class ret{

}
public class demo1 {
    public static int mutex = 1;
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        ret ret = new ret();
        Thread producer = new Thread(() -> {
            try {
                int num = 0;
                System.out.println("producer生产了" + num + "\n当前容量" + queue.size());
                queue.put(num);
                num++;
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();

        Thread consumer1 = new Thread(() -> {
                try {
                    int num = queue.take();
                    System.out.println("consumer1消费了" + num + "\n当前容量" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        consumer1.start();

        Thread consumer2 = new Thread(() -> {
                try {
                    int num = queue.take();
                    System.out.println("consumer2消费了" + num + "\n当前容量" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        consumer2.start();
    }
}
