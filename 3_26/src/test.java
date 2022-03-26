/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/26 9:15
 * @Version 1.0
 */

class Base{
    public Base(String s){
        System.out.print("B");
    }
}
class Derived extends Base {
    public Derived(String s) {
        super(s);
        System.out.print("D");
    }

    public static void main(String[] args) {
        new Derived("C");
    }
}

class A{
    A(int x){

    }
    A(int x , int y){
        this(x);
    }
}
abstract class b{
    abstract  void ment();
}
public class test {
    static void fun(StringBuffer a,StringBuffer b){
        a.append(b);
        b = a;
    }

    /*public static void main5(String[] args) {
        if((j + 2) < flg[0].length && flg[i][j+2] == true){
            return false;
        }
        if((j - 2) >= 0 && flg[i][j-2] == true){
            return false;
        }
        if((i + 2) < flg.length && flg[i+2][j] == true){
            return false;
        }
        if((i - 2) >= 0 && flg[i-2][j] == true){
            return false;
        }
    }*/
    public static void main4(String[] args) {
        int a = 10;
        try{
            a += 10;
        }catch (Exception e){

        }
        finally {
            a += 10;
        }
        System.out.println(a);
        double d = 0x2425;
        //byte v = 128;
        long te = 012;
    }

    public static void main3(String[] args) {
        boolean b = true ? false : true == true ? false : true;
        System.out.println(b);
    }
    public static void main2(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        fun(a,b);
        System.out.println(a+""+b);
    }
    public static void main1(String[] args) {
        String s;
        System.out.println("s = " );
        int x = 5 >> 2;
        int y = x >> 2;
        System.out.println(y);
    }
}
