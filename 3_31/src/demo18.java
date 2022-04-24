/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/9 19:23
 * @Version 1.0
 */

public class demo18 {
    public static int count = 0;
    synchronized private static void crease(){
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                crease();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                crease();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
