/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/16 15:53
 * @Version 1.0
 */

public class demo1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                System.out.println("t1线程正在运行~~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            while(true){
                System.out.println("t2线程正在运行~~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
