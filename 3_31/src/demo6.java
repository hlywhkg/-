/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:27
 * @Version 1.0
 */

public class demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            System.out.println("hello");
        });
        //t.start();
        t.run();
    }
}
