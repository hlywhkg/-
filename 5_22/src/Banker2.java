import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/22 19:51
 * @Version 1.0
 */

public class Banker2 {
    //允许的最大进程数量和资源种类
    final int MAX = 100;
    //系统中每种资源的总量
    int[] Resource = new int[MAX];
    //没有分配的每种资源总量
    int[] Available = new int[MAX];
    //每个进程对于每种资源的最大需求
    int[][] Need = new int[MAX][MAX];
    //当前分配情况
    int[][] Allocation = new int[MAX][MAX];

    Scanner sc = new Scanner(System.in);

    public void init() {
        boolean flg;
        System.out.println("请输入资源的种类数量");
        int N = sc.nextInt();
        System.out.println("请输入各个资源的最大数量Resource[]");
        for (int i = 0; i < N; i++) {
            Resource[i] = sc.nextInt();
        }
        System.out.println("请输入进程的数量");
        int M = sc.nextInt();
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
                    Available[j] = Resource[j] - Allocation[i][j];
                }
            }
            if(flg) {
                System.out.println("已分配资源数大于系统最大资源数,请重新输入!");
            }
        }while(flg);
    }

    //显示资源分配矩阵
    public void showData(int m,int n){
        int count = 1;
        System.out.println("***********************************");
        System.out.println("系统目前可用资源Available[]");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d r",count);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d",Available[i]);
        }

        System.out.println();
        System.out.println("系统当前所有矩阵情况如下:");
        String a = "Max",b = "Allocation",c = "Need",d = "进程名";
        System.out.printf("%-12s\t%-12s\t%-12s\t",a,b,c);
        System.out.printf("%-6s",d);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-4d\t r",count);
            }
        }
        System.out.println();

    }

}
