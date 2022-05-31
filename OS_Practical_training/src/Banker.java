/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/26 20:07
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/22 19:51
 * @Version 1.0
 */

public class Banker {
    //允许的最大进程数量和资源种类
    final static int MAX = 100;
    //系统中每种资源的总量
    int[] Resource = new int[MAX];
    //没有分配的每种资源总量
    int[] Available = new int[MAX];
    //每个进程对于每种资源的最大需求
    int[][] Need = new int[MAX][MAX];
    //当前分配情况
    int[][] Allocation = new int[MAX][MAX];
    //进程对资源的请求
    int Request[] = new int[MAX];
    //已经不占用资源的进程
    int finish[] = new int[MAX];
    //进程还需要的资源个数
    int[][] NeedR = new int[MAX][MAX];
    //存放安全序列
    int Security[] = new int[MAX];

    Scanner sc = new Scanner(System.in);

    //进程的数量M,资源的数量N,当前申请资源的进程I
    static int M,N,I;
    public void init() {
        boolean flg;
        System.out.println("请输入资源的种类数量");
        N = sc.nextInt();
        System.out.println("请输入各个资源的最大数量Resource[]");
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            Resource[i] = x;
            Available[i] = x;
        }
        System.out.println("请输入进程的数量");
        M = sc.nextInt();
        System.out.println("请输入各个进程所需的各个资源最大数量Need[]");
        do {
            flg = false;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    Need[i][j] = sc.nextInt();
                    if(Need[i][j] > Resource[j]){
                        flg = true;
                    }
                }
            }
            if(flg){
                System.out.println("资源最大需求量大于系统中的资源最大数,请重新输入!");
            }
        }while(flg);

        do {
            flg=false;
            System.out.println("请输入各进程已经分配的资源量[Allocation]:");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    Allocation[i][j] = sc.nextInt();
                    if(Allocation[i][j] > Resource[j]){
                        flg = true;
                    }
                    Available[j] -= Allocation[i][j];
                    NeedR[i][j] = Need[i][j] - Allocation[i][j];
                }
            }
            if(flg) {
                System.out.println("已分配资源数大于系统最大资源数,请重新输入!");
            }
        }while(flg);
    }

    //显示资源分配矩阵
    public void showData(){
        int count = 1;
        System.out.println("***********************************");
        System.out.println("系统当前所有矩阵情况如下:");
        String a = "Available[]",b = "Allocation[]",c = "Need[]";
        System.out.printf("      %-9s\t",a);
        System.out.println();
        System.out.print("资源");
        for (int j = 0; j < N; j++) {
            System.out.printf(" r%-1d\t ",count);
            count++;
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.printf("      %-1d\t",Available[i]);
        }

        System.out.println();
        System.out.printf("      %-9s\t",b);
        System.out.println();
        System.out.print("资源 ");
        count = 1;
        for (int j = 0; j < N; j++) {
            System.out.printf("r%-1d\t ",count);
            count++;
        }
        count = 1;
        System.out.println();
        for (int i = 0; i < M; i++) {
            System.out.printf("p%-2d\t ",count);
            count++;
            for (int j = 0; j < N; j++) {
                System.out.printf("%-1d\t",Allocation[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.printf("      %-9s\t",c);
        System.out.println();
        System.out.print("资源 ");
        count = 1;
        for (int j = 0; j < N; j++) {
            System.out.printf("r%-1d\t ",count);
            count++;
        }
        System.out.println();
        count = 1;
        for (int i = 0; i < M; i++) {
            System.out.printf("p%-2d\t ",count);
            count++;
            for (int j = 0; j < N; j++) {
                System.out.printf("%-1d\t",Need[i][j]);
            }
            System.out.println();
        }

    }

    //分配资源
    public int test()
    {
        int count = 0;
        for(int j = 0 ; j < N ; j++)
        {
            Available[j] = Available[j] - Request[j];
            Allocation[I-1][j] += Request[j];
            NeedR[I-1][j] -= Request[j];
            if(NeedR[I-1][j] == 0){
                count++;
            }
        }
        if(count == N){
            RTest();
            return 1;
        }else {
            return 0;
        }
    }

    public void Rtest(){
        for(int j = 0 ; j < N ; j++)
        {
            Available[j] += Request[j];
            Allocation[I-1][j] -= Request[j];
            NeedR[I-1][j] += Request[j];
        }
    }

    //释放资源
    public void RTest(){
        for (int j = 0; j < N; j++) {
            Available[j] += Allocation[I-1][j];
            Allocation[I-1][j] = 0;
            Need[I-1][j] = 0;
        }
    }

    //进程请求资源
    public boolean RequestR(){
        int j,count = 1;
        System.out.println("请输入请求分配资源的进程号(1~"+(M)+"):");
        I = sc.nextInt();
        System.out.println("请输入进程P"+I+"要申请的资源个数:");
        for(j = 0 ; j < N ; j++)
        {
            System.out.print("r" + count + ":");
            count++;
            Request[j]=sc.nextInt();//输入需要申请的资源
        }
        char result = CheckReasonable();
        if(result == 'Y') {
            System.out.println("请求分配成功");
            int ret = test();
            if(ret == 1){
                System.out.println("p" + I + "运行完毕");
            }
            showData();
            return true;
        }else if(result == 'A'){
            System.out.println("进程p" + I + "申请的资源大于系统空闲资源");
            System.out.println("分配不合理，不予分配！");
            return false;
        }else if(result == 'N') {
            System.out.println("进程p" + I + "申请的资源大于自身需求资源");
            System.out.println("分配不合理，不予分配！");
            return false;
        }else{
            System.out.println("不予分配");
        }
        return false;
    }

    //检查分配资源是否合理
    public char CheckReasonable(){
        boolean flg = CheckedSafe();
        if(!flg){
            return 'U';
        }
        for (int i = 0; i < N; i++) {
            if(Request[i] > Available[i]){
                return 'A';
            }else if(Request[i] > NeedR[I-1][i]) {
                return 'N';
            }
        }
        return 'Y';
    }

    //安全算法检查,检查是否安全
    private static int flg = 0;
    static int count1 = 0;
    public boolean CheckedSafe(){
        //初始情况所有资源应该是已经分配过资源
        //0,代表还占用者.1,代表不在占用
        if(count1 != 0){
            test();
        }
        int[] work = new int[N];
        for (int i = 0; i < N; i++) {
            work[i] = Available[i];
        }
        for (int i = 0; i < M; i++) {
            finish[i] = 0;
        }
        int apply,count = 0;
        for(int i = 0 ;i < M ; i++)
        {
            apply=0;
            for(int j = 0 ; j < N ; j++)
            {
                if(finish[i] == 0 && NeedR[i][j] <= work[j])
                {
                    apply++;//直到每类资源尚需数都小于系统可利用资源数才可分配
                    if(apply == N)
                    {
                        for(int k = 0 ; k < N ; k++)
                        {
                            work[k] += Allocation[i][k];//更改当前可分配资源
                        }
                        finish[i] = 1;
                        Security[count++] = i + 1;
                        i = -1; //保证每次查询均从第一个进程开始
                    }
                }
            }
        }
        for(int i = 0 ; i < M ; i++)
        {
            if(finish[i] == 0)
            {
                System.out.println("系统不安全！");
                if(count1 != 0){
                    Rtest();
                }
                ++count1;
                return false;
            }
        }
        if(flg == 0) {
            System.out.println("系统安全！");
            System.out.println("存在一个安全序列：");
            flg++;
            for(int i = 0 ; i < M;i++)
            {
                System.out.print("P"+Security[i]);
                if(i < M - 1)
                {
                    System.out.print("->");
                }
            }
        }
        System.out.println();
        if(count1 != 0){
            Rtest();
        }
        ++count1;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banker banker = new Banker();
        String choice;
        System.out.println("*************************************************************");
        System.out.println("                                                       银行家算法的实现  ");
        System.out.println("*************************************************************");
        banker.init();
        banker.showData();

        if(!banker.CheckedSafe()) {
            System.out.println("系统不存在安全序列");
            System.exit(0);
        }


        do
        {
            System.out.println("*************************************************************");
            System.out.println("                     R(r):请求分配 ");
            System.out.println("                     E(e):退出        ");
            System.out.println("                     E(s):当前矩阵分配情况        ");
            System.out.println("*************************************************************");
            System.out.print("请选择：");
            choice = sc.nextLine();
            switch(choice)
            {
                case "r":
                case "R":
                    banker.RequestR();
                    break;
                case "e":
                case "E":
                    System.exit(0);//System.exit(0)是正常退出程序，System.exit(1)表示非正常退出程序。
                case "s":
                case "S":
                    banker.showData();
                    break;
                default:
                    System.out.println("请正确选择！");
                    break;
            }
        }while(choice!="");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        Banker banker = new Banker();
        String choice;
        System.out.println("*************************************************************");
        System.out.println("                                                       银行家算法的实现  ");
        System.out.println("*************************************************************");
        banker.init();
        banker.showData();

        if(!banker.CheckedSafe()) {
            System.out.println("系统不存在安全序列");
            System.exit(0);
        }

        do
        {
            System.out.println("*************************************************************");
            System.out.println("                     R(r):请求分配 ");
            System.out.println("                     E(e):退出        ");
            System.out.println("*************************************************************");
            System.out.print("请选择：");
            choice = sc.nextLine();
            switch(choice)
            {
                case "r":
                case "R":
                    banker.RequestR();
                    break;
                case "e":
                case "E":
                    System.exit(0);//System.exit(0)是正常退出程序，System.exit(1)表示非正常退出程序。
                default:
                    System.out.println("请正确选择！");
                    break;
            }
        }while(choice!="");
    }


}

