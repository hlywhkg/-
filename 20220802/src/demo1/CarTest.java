package demo1;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/2 10:09
 * @Version 1.0
 */

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        int size = 20;
        car.init(size);
    }
}

/**
 * 车 依赖车身
 */
class Car{
    public void init(int size){
        FrameWork frameWork = new FrameWork();
        frameWork.init(size);
    }
}

/**
 * 车身 依赖底盘
 */
class FrameWork{
    public void init(int size){
        Bottom bottom = new Bottom();
        bottom.init(size);
    }
}

/**
 * 底盘 依赖于轮胎
 */
class Bottom{
    public void init(int size){
        Tire tire = new Tire();
        tire.init(size);
    }
}

class Tire{
    private int size;
    public void init(int size){
        System.out.println("轮胎尺寸" + size);
    }
}