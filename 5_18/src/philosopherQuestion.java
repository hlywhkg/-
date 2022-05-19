/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/19 2:31
 * @Version 1.0
 */

public class philosopherQuestion {

    private static boolean chopsticks[] = new boolean[]{false,false,false,false,false};
    private static String lock = "lock";

    class philosopher implements Runnable{
        private int id;
        public philosopher(int id){
            this.id = id;
        }

        //进餐
        public void eating(){
            System.out.println("我是哲学家"+id+"号"+",i am eating...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //思考
        public void thinking(){
            System.out.println("我是哲学家"+id+"号"+",i am thinking...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void takeChopSticks(){
                synchronized (lock) {
                    int min = Math.min(id,(id+1)%5);
                    int max = Math.max(id,(id+1)%5);
                    //哲学家先取小的,再取大的,只有两个都取到才开始进餐,否则就等待
                    while(chopsticks[min] || chopsticks[max]){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    chopsticks[min] = true;
                    chopsticks[max] = true;
                    /**
                     * 测试无效代码
                     */
                    /*if(!chopsticks[min]){
                        chopsticks[min] = true;
                        if(!chopsticks[max]){
                            chopsticks[max] = true;
                        }else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }*/
                }
        }

        public void putDownChopSticks() {
            synchronized (lock) {
                chopsticks[id] = false;
                chopsticks[(id+1)%5] = false;
                lock.notifyAll();
                System.out.println("我是哲学家" + id +"号,i finished eating");
            }
        }


        @Override
        public void run() {
            while(true) {
                thinking();
                takeChopSticks();
                eating();
                putDownChopSticks();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        philosopherQuestion p = new philosopherQuestion();
        new Thread(p.new philosopher(0)).start();
        new Thread(p.new philosopher(1)).start();
        new Thread(p.new philosopher(2)).start();
        new Thread(p.new philosopher(3)).start();
        new Thread(p.new philosopher(4)).start();

    }
}
