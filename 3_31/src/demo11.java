/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/3 15:25
 * @Version 1.0
 */

public class demo11 {
    public static int count = 0;
    synchronized public static void increase(){
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                increase();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                increase();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
