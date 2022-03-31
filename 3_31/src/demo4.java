/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:13
 * @Version 1.0
 */

public class demo4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();
    }
}
