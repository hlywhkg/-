import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/8 14:45
 * @Version 1.0
 */

public class test {

    private static int findIndex(int[]arr){
        int max = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            max = Math.max(arr[i],max);
        }
        return max;
    }

    private static int greedStrategy(int[] works, int[] machines){
        Arrays.sort(works);
        if(works.length <= machines.length){
            return works[works.length-1];
        }else{
            //为每台机器安排工作并且先安排时间最长的
            for(int i = works.length - 1 ; i >= 0 ; i--){
                //初始化
                int finish = 0;
                int machineTime = machines[finish];
                //找最先完成工作的机器并为其分配新的工作
                for(int j = 1 ; j < machines.length ; j++){
                    if(machines[j] < machineTime){
                        machineTime = machines[j];
                        finish = j;
                    }
                }
                //将该机器工作时间更新,最后在所有机器的工作时间中找最大的即可
                machines[finish] += works[i];
            }
        }
        return findIndex(machines);
    }

    public static void main(String[] args) {
        int n, m;
        System.out.println("请输入作业数和机器数");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] works = new int[n];
        int[] machines = new int[m];
        for (int i = 0; i < n; ++i)
            works[i] = scanner.nextInt();
        int x = greedStrategy(works, machines);
        System.out.println(x);
    }

    public static int solve(int money, int[][] moneyCount){
        int num = 0;
        //贪心策略,先从面值大的开始计算
        for (int i = moneyCount.length - 1; i > 0 ; i--) {
            //计算所需当前纸币所需的张数
            int c = money / moneyCount[i][0];
            //如果需要的钱金额小于当前纸币面值,或者当前纸币数量不够
            c = Math.min(c,moneyCount[i][1]);
            money -= c * moneyCount[i][0];
            num += c;
        }
        if(money != 0){
            //不能找到
            return -1;
        }else{
            return num;
        }
    }

    public static void main1(String[] args) {
        //存放纸币与数量: first:纸币，second:数量
        int[][]arr = {{ 1, 3 }, { 2, 1 }, { 5, 4 }, { 10, 3 }, { 20, 0 }
                ,{50, 1}, { 100, 10 }};
        Scanner scanner = new Scanner(System.in);
        int money;
        System.out.println("请输入要支付的钱");
        money = scanner.nextInt();
        int res = solve(money, arr);
        if (res != -1)
            System.out.println(res);
        else
            System.out.println("No");
    }
}
