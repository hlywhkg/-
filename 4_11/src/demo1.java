import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/11 20:35
 * @Version 1.0
 */
class MyThreadPool{
    //建立一个任务队列来存储需要进行的任务
    BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    //一个内部类里所有线程都有一个任务队列,且是同一个
    static class Worker extends Thread{

        BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                Runnable runnable = queue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    List<Worker> workers = new ArrayList<>();
    public MyThreadPool(int n){
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(queue);
            worker.start();
            workers.add(worker);
        }
    }

    public void submit(Runnable runnable){
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class demo1 {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        myThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 1 ; i < 100 ; i++){
                    System.out.println("我是任务" + i);
                }
            }
        });
    }
}
