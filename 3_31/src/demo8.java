/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/3 9:55
 * @Version 1.0
 */
public class demo8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(true){
                System.out.println("hello thread1");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            while(true){
                System.out.println("hello thread2");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread t2");
        t2.start();
        System.out.println("?????????");
    }
}
