/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 19:59
 * @Version 1.0
 */
class myThread extends Thread{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}
public class demo1 {
    public static void main(String[] args) {
        myThread myThread = new myThread();
        myThread.start();
    }
}
