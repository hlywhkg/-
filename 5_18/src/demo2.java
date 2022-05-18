/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/18 14:51
 * @Version 1.0
 */

class tmp{
    //空闲的缓冲去数目
    static int empty = 10;
    //当前所生产的产品
    static int produce;
    //当前剩余的产品数
    static int produces;
    //锁对象
    static Object locker = new Object();
}
//生产者
class producer extends tmp implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker) {
                while(produces == 10 || empty == 0) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    empty--;
                    produces++;
                    produce++;
                    System.out.println(Thread.currentThread() + "生产了产品" + produce + "    当前剩余产品数" + produces);
                    locker.notifyAll();
                }
            }
        }
    }
}

class consumer extends tmp implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker) {
                while(produces == 0 || empty == 10) {
                    try {
                       locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    empty++;
                    produces--;
                    System.out.println(Thread.currentThread() + "消费量产品 " + produce + "     当前剩余产品数" + produces);
                    locker.notifyAll();
                }
            }
        }
    }
}

public class demo2 {
    public static void main(String[] args) {
        Thread p1 = new Thread(new producer());
        Thread c1 = new Thread(new consumer());
        p1.start();
        c1.start();

    }
}
