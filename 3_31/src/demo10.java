/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/3 13:42
 * @Version 1.0
 */

public class demo10 {
    public static void main(String[] args) {
        /*Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getName());
            }
        };
        t.start();*/
        Thread t = new Thread(() ->{
            System.out.println(thread.currentThread().getName());
        });
        t.start();
    }
}
