/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/31 20:35
 * @Version 1.0
 */

public class demo7 {
    private static final long count = 1000_0000l;
    public static void serial(){
        long begin = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void current() throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            long a = 0;
            for (long i = 0 ; i < count ; i++){
                a++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            long b = 0;
            for(long i = 0 ; i < count ;i ++){
                b++;
            }
        });
        t2.start();
        //此处不能直接求出结束时间,因为这两个线程是和main线程一起并发执行的,此时t1,t2还没执行完,就已经计算出结束时间了,这显然是不科学的
        //因此正确的做法是,让main等待t1t2线程结束后才计算时间
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }
    public static void main(String[] args) throws InterruptedException {
        serial();
        current();
    }
}
