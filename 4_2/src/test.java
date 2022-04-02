/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/2 13:09
 * @Version 1.0
 */

public class test {
    static void add(int a){
        a = a++;
    }

    public static void main3(String[] args) {
        int a = 19;
        String str = Integer.toBinaryString(a);
        StringBuilder str2 = new StringBuilder(str);
        str2 = str2.reverse();

        System.out.println(str);
    }
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("100100000000");
        String b = "1001";
        System.out.println(Integer.parseInt(a.toString(),2));
        a = a.replace(2,6,a.toString());
        System.out.println(Integer.parseInt(a.toString(),2));
        System.out.println(a);
    }
    public static void main1(String[] args){
        int a = 10;
        add(a);
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(a);
        sb.append(100);
        System.out.println(sb.reverse());
        System.err.println(a);
    }
}
