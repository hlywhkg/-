/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/16 17:12
 * @Version 1.0
 */
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1116 {
    public static void test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        //Thread.sleep(3000);
        driver.get("https://www.baidu.com");
        /*Thread.sleep(3000);
        driver.findElement(By.cssSelector("#kw")).sendKeys("杨晨曦");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);*/
        //driver.quit();
        String str = driver.findElement(By.cssSelector("#su")).getText();
        System.out.println(str);
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
