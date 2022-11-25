/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/19 15:30
 * @Version 1.0
 */
package autoTest;

public class runTest {
    public static void main(String[] args) throws InterruptedException {
        _autoTest autoTest1 = new _autoTest();
        autoTest1.startTest();

        //autoTest1.gettitle();
        //autoTest1.windowTest();
        autoTest1.window2();

        autoTest1.endTest();
    }
}
