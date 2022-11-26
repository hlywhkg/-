/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/26 13:34
 * @Version 1.0
 */
package com;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class autoTest {
    private static ChromeDriver driver = new ChromeDriver();
    private static getParameter g = new getParameter();
    @Test
    @BeforeAll
    public static void getUrl(){
        driver.get("http://1.117.78.84:8081/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /////////////////////////


    @ParameterizedTest
    @MethodSource
    @Order(1)
    public void checkLogin(String name,String password) throws InterruptedException {
        Assertions.assertEquals(driver.findElement(By.cssSelector("#submit")).getAttribute("value"),"提交");
        Assertions.assertEquals(driver.findElement(By.cssSelector("#username")).getAttribute("name"),"username");
        Assertions.assertEquals(driver.findElement(By.cssSelector("#password")).getAttribute("name"),"password");
        driver.findElement(By.cssSelector("#username")).sendKeys(name);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#submit")).click();
    }

    static Stream<Arguments> checkLogin(){
        return Stream.of(Arguments.arguments(g.getLoginName(),"123"));
    }

    @ParameterizedTest
    @MethodSource
    @Order(2)
    public void checkList(Integer index) throws IOException, InterruptedException {
        Assertions.assertNotNull(driver.findElement(By.cssSelector("body > div.nav")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("body > div.container > div.left")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child("+index+")")));
        getScreenshot(getClass().getName());
        driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child("+index+") > a")).click();
        //Thread.sleep(5000);
        //body > div.container > div.right > div:nth-child(1)
        //body > div.container > div.right > div:nth-child(1) > a
    }

    static Stream<Integer> checkList(){
        return Stream.of(g.getIndex());
    }

    @Test
    @Order(3)
    public void checkContent() throws IOException, InterruptedException {
        Assertions.assertNotNull(driver.findElement(By.cssSelector("body > div.nav")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("body > div.container > div.right > div")));
        getScreenshot(getClass().getName());
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(5)")).click();
    }


    @Test
    @Order(4)
    public void checkEdit(){
        Assertions.assertNotNull(driver.findElement(By.cssSelector("#submit")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("#title")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("#editor > div.CodeMirror.cm-s-default.CodeMirror-wrap > div.CodeMirror-scroll")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector("#editor > div.editormd-preview")));
    }

    ////////////////////////

    @Test
    @AfterAll
    public static void exit(){
        driver.quit();
    }

    public List<String> getTime(){
        //文件名格式20221126-214130+毫秒
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyyMMdd-HHmmssSS");
        //文件夹名称格式2022-11-26
        SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd");
        String filename = sim1.format(System.currentTimeMillis());
        String dirname = sim2.format(System.currentTimeMillis());
        List<String> list = new ArrayList<>();
        list.add(dirname);
        list.add(filename);
        return list;
    }
    /**
     * 获取屏幕截图
     * str：类名下的用例
     */
    public void getScreenshot(String str) throws IOException {
        List<String> times = getTime();
        //生成的文件夹路径./src/test/photo-2022-11-26
        String filename ="./src/test/photo-"+times.get(0)+"/"+str+"-"+times.get(1)+".png";
        File srcfile = driver.getScreenshotAs(OutputType.FILE);
        //把屏幕截图放到指定的路径下
        FileUtils.copyFile(srcfile,new File(filename));
    }

}

