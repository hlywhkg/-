/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/10 11:54
 * @Version 1.0
 */
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int x = scan.nextInt();
            int count = 0;
            System.out.printf("%d = ",x);
            for(int i = 2 ; i * i <= x ; i++){
                while(x % i == 0){
                    if((x/i)%i == 0){
                        System.out.printf("%d *",i);
                    }else{
                        System.out.printf("%d",i);
                    }
                    x /= i;
                }
            }
            if(x > 1){
                System.out.printf(" * %d",x);
                System.out.print("\n");
            }
        }
    }
}

