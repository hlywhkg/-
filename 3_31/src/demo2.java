/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:02
 * @Version 1.0
 */
class thread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class demo2 {
    public static void main(String[] args) {
        thread t = new thread();
        t.start();
        while(true){
            System.out.println("hello main");
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
