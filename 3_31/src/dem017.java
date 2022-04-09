/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/9 10:30
 * @Version 1.0
 */

public class dem017 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true){
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        thread.sleep(1000);
        System.out.println(t1.getState());
    }
}
