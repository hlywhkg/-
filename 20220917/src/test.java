import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/17 11:46
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Thread t1 = new Thread(()->{
            while(true){

            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized (q){
                while(true){
                    try {
                        q.wait(10000);
                        System.out.println("---------------------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
        try {
            Thread.sleep(5000);
            t1.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
