/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/20 14:57
 * @Version 1.0
 */
package thread;

class thread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
        }
    }
}
public class demo1 {
    public static void main(String[] args) {
        thread t = new thread();
        t.start();
        long a = System.currentTimeMillis();

    }
}
