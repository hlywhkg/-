/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/10 22:50
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        String str1 = "create table teacher(name varchar(12),age int ,heigh int ,weigh int ,sex enum('男','女') ," +
                "education varchar(12),birthday varchar(12),id varchar(12))";
        String str2 = "create table good(name varchar(12),price int ,stock varchar(12),descr varchar(12));";
        String str3 = "insert book into values('Java核心技术','bit',10,'学习');";
        String str4 = " update book set price = 61 where bookName = 'Java核心技术';";
        String str5 = "create table book2(name varchar(12),author varchar(20),price double(4,2),classify varchar(12));";
        String str6 = "insert into book2 values('Java核心技术','Cay S. Horstman',56.43,'计算机');";
    }
}
