import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/9 20:39
 * @Version 1.0
 */

public class demo19 {
    public static int isQuit = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(isQuit == 0){
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1线程结束~~");
        });
        t1.start();
        Scanner scan = new Scanner(System.in);
        isQuit = scan.nextInt();
        System.out.println("main线程结束~~");
    }
}
