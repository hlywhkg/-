package demo2;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/2 10:43
 * @Version 1.0
 */

public class CarTest {

    public static void main(String[] args) {
        Tire tire = new Tire(10,"猛男粉");
        Bottom bottom = new Bottom(tire);
        FrameWork frameWork = new FrameWork(bottom);
        Car car = new Car(frameWork);
        car.init();
    }
}

class Car{
    private FrameWork frameWork;
    public Car(FrameWork frameWork){
        this.frameWork = frameWork;
    }
    public void init(){
        frameWork.init();
    }
}

class FrameWork{
    private Bottom bottom;
    public FrameWork(Bottom bottom){
        this.bottom = bottom;
    }
    public void init(){
        bottom.init();
    }
}

class Bottom{
    private Tire tire;

    public Bottom(Tire tire){
        this.tire = tire;
    }

    //初始化轮胎
    public void init(){
        tire.init();
    }
}

class Tire{
    private int size;
    private String color;
    public Tire(int size,String color){
        this.size = size;
        this.color = color;
    }
    public void init(){
        System.out.println("轮胎尺寸" + size + " 轮胎颜色 " + color);
    }
}

