import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/11 18:27
 * @Version 1.0
 */
//任务描述
class MyTask implements Comparable<MyTask>{
    private long time;
    private Runnable runnable;
    //delay是一个时间间隔
    public MyTask(Runnable runnable, long delay){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public void run(){
        runnable.run();
    }

    public long getTime(){
        return this.time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time - o.time);
    }
}
//定时器
class Timer{
    //每个定时器应该有很多任务描述
    PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();
    public void schedule(Runnable runnable, long delay){
        MyTask task = new MyTask(runnable,delay);
        queue.put(task);
        synchronized (locker){
            locker.notify();
        }
    }
    private Object locker = new Object();

    public Timer(){
        Thread t = new Thread(() -> {
            while(true){
                try {
                    MyTask task = queue.take();
                    long time = System.currentTimeMillis();
                    if(time < task.getTime()){
                        queue.put(task);
                        synchronized (locker){
                            locker.wait(task.getTime() - time);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
public class test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是定时任务一");
            }
        },3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是定时任务二");
            }
        },6000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是定时任务三");
            }
        },9000);
        System.out.println("main线程");
    }
}
