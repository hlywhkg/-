/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/11 22:00
 * @Version 1.0
 */

class A{
    int val;
    public A(int val){
        setValue(val);
    }

    public void setValue(int val) {
        this.val = val;
    }
}
class B extends A{

    public B(int val) {
        super(val);
    }

    public void setValue(int val){
        super.setValue(2 * val);
    }
}
public class demo1 {
    public static void main(String[] args) {
        B b = new B(10);
        System.out.println(b.val);
    }
}
