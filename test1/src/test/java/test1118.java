/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/18 9:55
 * @Version 1.0
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class test1118 {
    public static void test(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        /**
         *      隐式等待
         */
        /*driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        driver.findElement(By.cssSelector("#su")).click();
        driver.findElement(By.cssSelector("#\\31  > div > div.header-left_1BntJ > div.c-color-t.left-title_3lM8p.c-line-clamp1"));*/

        /**
         *      显示等待
         */
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        driver.findElement(By.cssSelector("#su")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("#\\31  > div > div.header-left_1BntJ > div.c-color-t.left-title_3lM8p.c-line-clamp1")));
        /***
         *      得到元素预期文本是否相同
         */
        wait.until(ExpectedConditions.textToBe(By.cssSelector(
                "#\\31  > div > div.header-left_1BntJ > div.c-color-t.left-title_3lM8p.c-line-clamp1"),"迪丽热巴"));
        driver.quit();
    }

    /**
     *     测试显示等待和隐式等待在查不到元素时等待时间
     *     结果不确定：可能为10、11、12
     *     因此是显示等待占主导地位
     */
    public static void wait1(){
        ChromeDriver driver = new ChromeDriver();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        driver.findElement(By.cssSelector("#su")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.cssSelector("#\\31  > div > div.header-left_1BntJ > div.c-color-t.left-title_3lM8p.c-line-clamp")));
        }catch (Exception e){
            System.out.println("nosuchelement");
        }
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        driver.quit();
    }

    public static void main(String[] args) {
        //test();
        wait1();
    }

}
