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
    public static int count = 0;
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        ret ret = new ret();
        synchronized (ret){
            Thread producer = new Thread(()->{
                int num = 0;
                while(true) {
                    System.out.println("producer生产了" + num + "\n当前容量" + queue.size());
                    try {
                        queue.put(num);
                        num++;
                        //Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            producer.start();
        }


        Thread consumer1 = new Thread(()->{
            while(true) {
                try {
                    int num = queue.take();
                    System.out.println("consumer1消费了" + num + "\n当前容量" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer1.start();

        Thread consumer2 = new Thread(()->{
            while(true) {
                try {
                    int num = queue.take();
                    System.out.println("consumer2消费了" + num + "\n当前容量" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer2.start();

        String str = new String("135 15");
        String str2[] = str.split(" ");
        System.out.println(str2[0]);
        System.out.println(str2[1]);
        Map<String,String> map = new HashMap<>();

    }
}
