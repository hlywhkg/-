/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:06
 * @Version 1.0
 */
class myRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}
public class demo3 {
    public static void main(String[] args) {
        /*Thread t = new Thread(new myRunnable());
        t.start();*/
        myRunnable t = new myRunnable();
        t.run();
    }
}
