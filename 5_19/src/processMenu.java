/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/19 15:20
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class JCB {
    String name;//进程名
    int arriveTime;//到达时间
    int serveTime;//服务时间
    int beginTime;//开始时间
    int finishTime;//完成时间
    double priority;//优先权等级
    int roundTime;//周转时间
    double aveRoundTime;//带权周转时间
    double clock = 0;//在时间轮转调度算法中，记录该进程真实服务时间已经用时的时长
    int waitTime;//记录每个进程到达后的等待时间，只用于最高响应比优先调度算法中
    boolean firstTimeTag = false;//在RR算法中标识开始时间是否第一次计算

    public JCB() {

    }

    public JCB(String name, int arriveTime, int serveTime, double priority) {
        super();
        this.name = name;
        this.arriveTime = arriveTime;
        this.serveTime = serveTime;
        this.waitTime = 0;
        this.priority = priority;
    }

    public String toString() {
        String info = new String("进程名：P" + this.name);
        return info;
    }

}


public class processMenu {

    ArrayList<JCB> jcb;// 存放所有进程
    LinkedList<JCB> link;// 存放已经进入队列的进程
    ArrayList<JCB> new_jcb;// 存放按指定调度算法排序后的进程
    JCB nowProcess;// 当前应执行进程

    public void init() {//初始化
        jcb = new ArrayList<JCB>();
        link = new LinkedList<JCB>();
        new_jcb = new ArrayList<JCB>();
        JCB p1 = new JCB("1", 0, 3,3);
        JCB p2 = new JCB("2", 2, 6,2);
        JCB p3 = new JCB("3", 4, 4,3);
        JCB p4 = new JCB("4", 6, 5,1);
        JCB p5 = new JCB("5", 8, 2,5);
        jcb.add(p1);jcb.add(p2);jcb.add(p3);jcb.add(p4);jcb.add(p5);
        //先将jcb排序，便于下面的算法实现，就不需要再定义一个标识进程是否已到达的boolean,即无需每次都从头开始扫描jcb容器，
        //而是用一个K记录下当前已经扫描到的位置，一次遍历即可，提高了算法效率。
        Collections.sort(jcb, new compareAt_St());
    }

    /**
     * 先来先服务算法
     */
    public void FCFS(){
        ProcessQueue pq=new ProcessQueue();//调用内部类
        pq.EnqueueLast();//让最先到达的进程先入队
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {//while(new_jcb.size()!=jcb.size())
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue();//出队，一次一个
            pq.EnqueueLast();//已到达的进程入队
        }
    }

    /**
     * 短作业优先算法
     */
    public void SJF() {
        ProcessQueue pq=new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue();//出队，一次一个
            pq.EnqueueLast();//已到达的进程入队
            Collections.sort(link, new compareSt());//队列中的进程还需按服务时间长度进行排序
        }
    }

    /**
     * 时间片轮转调度算法
     */
    public void RR() {
        ProcessQueue pq=new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue(1);//出队，一次一个，因为上一轮出的得让刚到达的进程先进队列，进队操作只能也放在这个函数里了
        }
    }

    /**
     * 最高响应比优先调度算法
     */
    public void HRN() {
        ProcessQueue pq = new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue();//出队，一次一个
            pq.EnqueueLast();//已到达的进程入队
            Collections.sort(link, new comparePriority());//队列中的进程还需按响应比进行排序
        }
    }

    /**
     * 优先权调度算法
     */
    public void priority(){
        ProcessQueue pq=new ProcessQueue();
        pq.EnqueueLast();
        System.out.println("*****************************************************");
        while(!link.isEmpty()) {
            pq.DisplayQueue();//打印当前队列中的进程
            pq.Dequeue(1);//出队，一次一个，因为上一轮出的得让刚到达的进程先进队列，进队操作只能也放在这个函数里了
        }
    }

    class ProcessQueue{
        int k = 0;// jcb中的进程遍历时的下标
        int nowTime = 0;// 当前时间
        double sliceTime;//轮转调度时间片
        int i=0;//记录当前出入队列的次数

        public void EnqueueLast() {//进程首次入队，可一次进多个,从队尾进入
            while (k < jcb.size()) {//当遍历完jcb中的所有进程时结束
                if (jcb.get(k).arriveTime <= nowTime) {//已经到达的进程按到达时间先后进入队列
                    link.addLast(jcb.get(k));
                    k++;
                } else {
                    break;//如果该进程还未入队，即先结束遍历，保留当前下标k值，注意：此处不要k--；
                }
            }
            /**
             * 此处只为最高响应比算法所用
             */
            for(int j=0;j<link.size();++j) {
                link.get(j).waitTime = nowTime - link.get(j).arriveTime;//所有进入等待队列的进程等待时间重新赋值
            }
        }

        public void Dequeue() {//进程出队，一次只出一个
            nowProcess = link.removeFirst();//移除队列的队首元素并且返回该对象元素
            nowProcess.beginTime = nowTime;//计算开始时间，即为上一个进程的结束时间
            nowProcess.finishTime = nowProcess.beginTime + nowProcess.serveTime;//计算完成时间，该进程开始时间+服务时间
            nowProcess.roundTime = nowProcess.finishTime - nowProcess.arriveTime;//计算周转时间
            nowProcess.aveRoundTime = (double) nowProcess.roundTime / nowProcess.serveTime;//计算带权周转时间
            nowTime = nowProcess.finishTime;//获得结束时间，即当前时间，方便判断剩下的进程是否已到达
            new_jcb.add(nowProcess);//经处理过数据后加入new_jcb容器
        }


        public void Dequeue(double sliceTime) {//重载Dequeue方法，实现轮转调度算法的出队及优先权调度算法
            nowProcess = link.removeFirst();//移除队列的队首元素并且返回该对象元素
            if(nowProcess.firstTimeTag==false) {
                /*轮转调度进程可能会多次反复进出队列，不像FCFS和SJF的进程只会进出一次，所以计算开始时间可以设个标志位，让每个进程在
                 * 第一次执行时记录一遍即可*/
                nowProcess.beginTime=nowTime;//进程开始执行的时间
                nowProcess.firstTimeTag=true;//计算第一次即可，下次无需更新计算
            }
            nowTime += sliceTime;//每次出队，用时一个时间片，更新当前时间
            nowProcess.clock += sliceTime;//更新当前出队列的进程已服务时间
            nowProcess.priority -= sliceTime * 2.5;//进程在占用cpu时,会以1.5倍速下降优先权
            if(nowProcess.clock>=nowProcess.serveTime) {
                nowProcess.finishTime=nowTime;//计算该进程完成时间
                nowProcess.roundTime = nowProcess.finishTime - nowProcess.arriveTime;//计算周转时间
                nowProcess.aveRoundTime = (double) nowProcess.roundTime / nowProcess.serveTime;//计算平均周转时间
                new_jcb.add(nowProcess);//经处理过数据后加入new_jcb容器
                EnqueueLast();//已到达的进程先入队
                Collections.sort(link,new compare_AtPr());
            }
            else {
                EnqueueLast();//已到达的进程先入队
                link.addLast(nowProcess);//上一轮出的再紧接着进入队尾
                Collections.sort(link,new compare_AtPr());
            }
            for(int i = 0 ; i < link.size() ; i++) {//处于等待状态的进程以1倍速增长优先权等级
                link.get(i).priority += sliceTime;
            }
        }

        public void DisplayQueue(){//队列中等候的进程
            i++;
            System.out.println("第"+i+"次队列中排队的进程："+link);
        }
    }
    public void printProcess() {
        System.out.println("进程名 到达时间  服务时间   开始时间  完成时间  周转时间  带权周转时间");
        for (int i = 0; i < new_jcb.size(); ++i) {
            System.out.println("P"+new_jcb.get(i).name + "      " + new_jcb.get(i).arriveTime + "        " +
                    new_jcb.get(i).serveTime+ "       " + new_jcb.get(i).beginTime + "       " + new_jcb.get(i).finishTime +
                    "        "+ new_jcb.get(i).roundTime + "         " + new_jcb.get(i).aveRoundTime);
        }
        new_jcb.clear();//清空new_jcb容器内的内容，方便存储各种算法的结果并展示
    }
}

class compareSt implements Comparator<JCB> {// 按服务时间升序
    public int compare(JCB arg0, JCB arg1) {
        return arg0.serveTime - arg1.serveTime;
    }
}

class compareAt_St implements Comparator<JCB> {// 按到达时间升序，若到达时间相同，按服务时间升序
    public int compare(JCB o1, JCB o2) {
        int a = o1.arriveTime - o2.arriveTime;
        if (a > 0)
            return 1;
        else if (a == 0) {
            return o1.serveTime > o2.serveTime ? 1 : -1;
        } else
            return -1;
    }
}

class comparePriority implements Comparator<JCB>{//按响应比降序排序

    public int compare(JCB o1, JCB o2) {
        double r1 = o1.waitTime * 1.0 / o1.serveTime;
        double r2 = o2.waitTime * 1.0 / o2.serveTime;
        return r1 < r2 ? 1 :-1;
    }

}

class compare_AtPr implements Comparator<JCB>{//按优先权降序排序,如果优先权相同,按照先来先到,在就是服务时间
    public int compare(JCB o1, JCB o2) {
        if(o1.priority < o2.priority) {
            return 1;
        }else if(o1.priority == o2.priority){
            int a = o1.arriveTime - o2.arriveTime;
            if (a > 0)
                return 1;
            else if (a == 0) {
                return o1.serveTime > o2.serveTime ? 1 : -1;
            } else
                return -1;
        }else {
            return -1;
        }
    }
}

class TestProcess {
    public static void main(String[] args) {
        processMenu pm=new processMenu();
        pm.init();//初始化容器
        pm.FCFS();pm.printProcess();
        pm.SJF();pm.printProcess();
        //pm.RR();pm.printProcess();
        pm.HRN();pm.printProcess();
        pm.priority();pm.printProcess();
    }
}
