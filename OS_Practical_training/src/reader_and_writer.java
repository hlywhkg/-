/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/26 19:33
 * @Version 1.0
 */



public class reader_and_writer {
    private static int readerCount = 0;
    //reading 表示读信号量 当 reading = true 时 表示有线程在读无法进行写操作
    private static boolean reading = false;
    //writing 表示写信号量 当 writing = true 时 表示有线程在写无法进行读操作
    private static boolean writing = false;

    //开始读操作
    public synchronized void startRead() {
        //只有当没有写者时,才允许进行读操作
        //允许多个读操作
        while (writing == true) {
            System.out.println(Thread.currentThread().getName() + " is waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " begin to read");
        readerCount++;
        //只要读者有一个人就将reading赋true,不需要重复赋值
        if (readerCount == 1) {
            reading = true;
        }
    }

    //结束读操作
    public synchronized void endRead(){
        --readerCount;
        System.out.println(Thread.currentThread().getName() + " reading done!");
        if(readerCount == 0){
            reading = false;
            System.out.println(" can be reading or writing");
        }
        notifyAll();
    }

    //开始写操作
    public synchronized void startWrite(){
        //只有当没有读者且没有其他写者时才能开始写操作
        while(reading == true || writing == true){
            try {
                System.out.println(Thread.currentThread().getName() + " can not writing");
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writing = true;
        System.out.println(Thread.currentThread().getName() + " is writing");
    }

    //结束写操作
    public synchronized void endWrite(){
        writing = false;
        System.out.println(Thread.currentThread().getName() + " writing done");
        System.out.println(" can be reading or writing!");
        notifyAll();
    }


    static class reader implements Runnable{
        reader_and_writer r;
        public reader(reader_and_writer r){
            this.r = r;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在申请读操作....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.startRead();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.endRead();
        }
    }

    static class writer implements Runnable{
        reader_and_writer w ;
        public writer(reader_and_writer w){
            this.w = w;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在申请写操作.....");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            w.startWrite();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            w.endWrite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        reader_and_writer wr = new reader_and_writer();
        new Thread(new writer(wr)).start();
        new Thread(new reader(wr)).start();
        new Thread(new writer(wr)).start();
        //new Thread(new reader(wr)).start();
        //new Thread(new reader(wr)).start();
        //new Thread(new writer(wr)).start();
        //测试写的时候不能读
        Thread t = new Thread(new reader(wr));
        Thread.sleep(4000);
        t.start();
    }

    public void run() throws InterruptedException {
        reader_and_writer wr = new reader_and_writer();
        new Thread(new writer(wr)).start();
        new Thread(new reader(wr)).start();
        new Thread(new writer(wr)).start();
        //new Thread(new reader(wr)).start();
        //new Thread(new reader(wr)).start();
        //new Thread(new writer(wr)).start();
        //测试写的时候不能读
        Thread t = new Thread(new reader(wr));
        Thread.sleep(4000);
        t.start();
        t.join();
    }
}




