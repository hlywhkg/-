/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/12 21:23
 * @Version 1.0
 */

public class demo1 {
    public static void main(String[] args) {
       boolean flg = true;
        System.out.println((flg = !flg) ? 1 : -1);
        System.out.println((flg = !flg) ? 1 : -1);
    }
}
