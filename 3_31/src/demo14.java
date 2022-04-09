/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/9 9:05
 * @Version 1.0
 */

public class demo14 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //判断当前是否设置了标志位,如果设置了并且当前线程处于中断情况下返回true
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("t1线程正在运行~~~~");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        t1.start();
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //调用interrupt使使用这个方法的线程中断
        t1.interrupt();
        System.out.println("t1线程终止~~");
    }
}
