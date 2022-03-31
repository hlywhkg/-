/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:17
 * @Version 1.0
 */

public class demo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        thread.start();
    }
}
