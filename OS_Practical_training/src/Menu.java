import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/30 16:45
 * @Version 1.0
 */

public class Menu {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            System.out.println("*****************主菜单*******************");
            System.out.println("******    一.进程的同步与互斥  *************");
            System.out.println("******  1.生产者消费者模型  ****************");
            System.out.println("******  2.读者写者问题  *******************");
            System.out.println("******  3.哲学家进餐问题  ******************");
            System.out.println("******    二.进程调度  ********************");
            System.out.println("******  4.先来先服务算法  ******************");
            System.out.println("******  5.短作业优先算法  ******************");
            System.out.println("******  6.时间片轮转算法  ******************");
            System.out.println("******  7.优先权调度算法  ******************");
            System.out.println("******  8.最高响应比优先算法  ***************");
            System.out.println("******    三.设备管理  ********************");
            System.out.println("******  9.银行家算法  *********************");
            System.out.println("******    四.文件管理  ********************");
            System.out.println("******  10.最短寻道时间优先算法  ************");
            System.out.println("******  11.扫描算法  **********************");
            System.out.println("******    五.存储管理  ********************");
            System.out.println("******  12.先进先出淘汰算法  ***************");
            System.out.println("******  13.最佳置换算法  ******************");
            System.out.println("******  14.最近最久未使用算法  *************");
            System.out.println("******  0.退出  *************************");
            System.out.println("请输入选择的算法:-> ");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            switch (choose) {
                case 0:
                    System.exit(0);
                case 1 :
                    producer_and_consumer p = new producer_and_consumer();
                    p.run();
                    break;
                case 2 :
                    reader_and_writer r = new reader_and_writer();
                    try {
                        r.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3 :
                    philosopher_Question ph = new philosopher_Question();
                    ph.run();
                    break;
                case 4 :
                    processMenu pm1 = new processMenu();
                    pm1.FCFSRun();
                    break;
                case 5:
                    processMenu pm2 = new processMenu();
                    pm2.SJFRun();
                    break;
                case 6 :
                    processMenu pm3 = new processMenu();
                    pm3.RRRun();
                    break;
                case 7:
                    processMenu pm4 = new processMenu();
                    pm4.PriorityRun();
                    break;
                case 8:
                    processMenu pm5 = new processMenu();
                    pm5.HNRRun();
                    break;
                case 9 :
                    Banker b = new Banker();
                    b.run();
                    break;
                case 10:
                    SSTF sstf = new SSTF();
                    sstf.run();
                    break;
                case 11 :
                    SCAN scan1 = new SCAN();
                    scan1.run();
                case 12:
                    Memory_Management m1 = new Memory_Management();
                    m1.FIFOrun();
                    break;
                case 13:
                    Memory_Management m2 = new Memory_Management();
                    m2.LRUrun();
                    break;
                case 14:
                    Memory_Management m3 = new Memory_Management();
                    m3.OPTrun();
                    break;
                default:
                    System.out.println("输错了,请重新输入");
            }
        }
    }
}
