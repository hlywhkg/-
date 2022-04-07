/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/7 20:47
 * @Version 1.0
 */

public class demo13 {
    private static boolean flg = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(!flg){
                System.out.println("hello thread1");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flg = true;
        System.out.println("main线程结束");
    }
}
