/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/6 13:27
 * @Version 1.0
 */

public class demo12 {
    public static void main(String[] args) {
        Thread t1 = new Thread( () ->{
            while(true){
                System.out.println("hello I am thread1");
                //由于线程的运行速度很快,我们人眼观测不出来
                //所以使用sleep休眠1000毫秒也就是1秒
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        while(true){
            System.out.println("hello I am main");
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
