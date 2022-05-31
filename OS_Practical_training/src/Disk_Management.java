/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/28 10:26
 * @Version 1.0
 */

import java.util.List;
import java.util.Scanner;

//最短寻道时间优先
class SSTF{
    //访问磁道序列数组
    private int visit[];
    //记录最近磁道的下标
    private int nearIndex=0;
    public int[] sstf(int queue[],int start){
        //记录最近的磁道序列
        int nearNum;
        visit = new int[queue.length];
        for(int i = 0 ; i < queue.length ; i++){
            nearNum = Integer.MAX_VALUE;
            for(int j = 0 ; j < queue.length ; j++){
                if(queue[j] != -1){
                    if(Math.abs(nearNum - start) > Math.abs(queue[j] - start)){
                        nearNum = queue[j];
                        nearIndex = j;
                    }
                }
            }
            visit[i] = nearNum;
            queue[nearIndex] = -1;
            start = nearNum;
        }
        return visit;
    }
    public void print(int visit[],int start){
        double sum=0;
        System.out.print("访问序列：");
        for(int i = 0 ; i < visit.length ;i++){
            System.out.print(visit[i] + " ");
            sum = Math.abs(visit[i] - start ) + sum;
            start = visit[i];
        }
        System.out.println();
        System.out.println("经过的磁道总数：" + sum);
        System.out.println("平均寻道长度：" + sum / visit.length);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入磁盘请求序列长度：");
        int a=sc.nextInt();
        System.out.println("请输入磁盘请求访问序列：");
        int[] queue = new int[a];
        for(int i = 0 ;i < a ; i++){
            queue[i] = sc.nextInt();
        }
        SSTF sstf = new SSTF();
        System.out.println("请输入读写头起始位置：");
        int start = sc.nextInt();
        sstf.print(sstf.sstf(queue, start),start);
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入磁盘请求序列长度：");
        int a=sc.nextInt();
        System.out.println("请输入磁盘请求访问序列：");
        int[] queue = new int[a];
        for(int i = 0 ;i < a ; i++){
            queue[i] = sc.nextInt();
        }
        SSTF sstf = new SSTF();
        System.out.println("请输入读写头起始位置：");
        int start = sc.nextInt();
        sstf.print(sstf.sstf(queue, start),start);
    }
}

//扫描算法
class SCAN{
    private int visit[];
    private int nearIndex = 0;
    public int[] scan(int queue[],int start,int direction){
        int nearNum;
        int index = 0;
        visit = new int[queue.length];
        for(int i = 0 ; i < queue.length ; i++){
            index = -1;
            nearNum = Integer.MAX_VALUE;
            for(int j = 0 ; j < queue.length ; j++){
                if(queue[j] != -1){
                    //向序列号增加的方向寻道
                    if((direction == 1) && (queue[j] > start) && (Math.abs(nearNum-start) > Math.abs(queue[j] - start))){
                        nearNum = queue[j];
                        nearIndex = j;
                        //index = 0 之后代表已经找到了一个适合序列,可以放进数组中了
                        index = 0;
                     //向序列号减小的方向寻道
                    }else if((direction == 0) && (queue[j] < start) && (Math.abs(nearNum - start) > Math.abs(queue[j] - start))){
                        nearNum = queue[j];
                        nearIndex = j;
                        //index = 0 之后代表已经找到了一个适合序列,可以放进数组中了
                        index = 0;
                    }
                }
            }
            if((direction == 1) && (index == -1)){
                direction = 0;
                //找了一次后没有找到需要反向,且i++ 了两次需要 -1和数组下标对应
                i = i - 1;
            } else if((direction  == 0) && (index == -1)){
                direction = 1;
                i = i - 1;
            }
            if(index == 0){
                visit[i] = nearNum;
                queue[nearIndex] = -1;
                start = nearNum;
            }
        }
        return visit;
    }

    public void print(int visit[],int start) {
        double sum = 0;
        System.out.print("访问序列：");
        for(int i = 0 ; i < visit.length ; i++) {
            System.out.print(visit[i]+" ");
            sum = Math.abs(visit[i] - start) + sum;
            start = visit[i];
        }
        System.out.println();
        System.out.println("经过的磁道总数："+ sum);
        System.out.println("平均寻道长度："+ sum / visit.length);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入磁盘请求序列长度：");
        int a = sc.nextInt();
        System.out.println("请输入磁盘请求访问序列：");
        int[] queue = new int[a];
        for(int i = 0 ; i < a ; i++) {
            queue[i] = sc.nextInt();
        }
        SCAN scan = new SCAN();
        System.out.println("请输入读写头起始位置：");
        int start = sc.nextInt();
        System.out.println("磁道增加的方向：（0向磁道号减少的方向移动,1向磁道号增加的方向移动）");
        int direction = sc.nextInt();
        scan.print(scan.scan(queue, start,direction),start);
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入磁盘请求序列长度：");
        int a = sc.nextInt();
        System.out.println("请输入磁盘请求访问序列：");
        int[] queue = new int[a];
        for(int i = 0 ; i < a ; i++) {
            queue[i] = sc.nextInt();
        }
        SCAN scan = new SCAN();
        System.out.println("请输入读写头起始位置：");
        int start = sc.nextInt();
        System.out.println("磁道增加的方向：（0向磁道号减少的方向移动,1向磁道号增加的方向移动）");
        int direction = sc.nextInt();
        scan.print(scan.scan(queue, start,direction),start);
    }
}

