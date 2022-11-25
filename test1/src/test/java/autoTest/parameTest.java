/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/24 11:02
 * @Version 1.0
 */
package autoTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;


public class parameTest {

    /**
     * 单参数
     * @ValueSource - strings
     * @param name
     */
    @ParameterizedTest
    @ValueSource(strings = {"苹果","香蕉","梨"})
    public void singleTest(String name){
        System.out.println(name);
    }

    /**
     * 多参数
     * CsvSource - value
     * 指定参数中的分隔符 delimiterString
     * 如果 参数中有分隔符 可以使用单引号区分 "'张-三'-20-男"
     * @param name
     * @param age
     * @param sex
     */
    @ParameterizedTest
    @CsvSource(value = {"张三-18-男","李四-20-女","王五-100-男"},delimiterString = "-")
    public void moreTest(String name,int age,String sex){
        System.out.println(name+" "+age+" "+sex);
    }

    /**
     * 多参数-文件
     * 参数太多代码中不好看,可以写在一个文件中
     */
    @ParameterizedTest
    //当前项目的resource文件下
    //@CsvFileSource(resources = "/my.csv")
    //任意位置
    @CsvFileSource(files = "D:\\gitee\\one-question-per-day\\test1\\src\\main\\resources\\my.csv")
    public void FileTest(String name,int price){
        System.out.println(name+" "+price);
    }


    /**
     * 动态单参数
     * @param name
     */
    @ParameterizedTest
    //可以指定方法
    //@MethodSource("parameter")
    //不指定就是找与此方法同名
    @MethodSource
    public void dynamicTest(String name){
        System.out.println(name);
    }

    /**
     * 提供动态参数的方法必须是static的
     * @return
     */
    static Stream<String> parameter(){
        return Stream.of("张三","李四","王五");
    }
    static Stream<String> dynamicTest(){
        return Stream.of("张三疯","李四","王五");
    }

    /**
     * 动态多参数
     */
    @ParameterizedTest
    @MethodSource()
    public void dynamicMoreTest(String name,int age,String sex){
        System.out.println(name+" "+age+" "+sex);
    }

    static Stream<Arguments> dynamicMoreTest(){
        return Stream.of(Arguments.arguments("张三",18,"男"),
                Arguments.arguments("李四",20,"女"),
                Arguments.arguments("王五",98,"女"));
    }
}
