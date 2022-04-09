/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/9 10:12
 * @Version 1.0
 */

public class demo15 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.interrupted());
            }
        });
        t1.start();
        t1.interrupt();
    }
}
