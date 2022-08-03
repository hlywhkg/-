/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/2 14:36
 * @Version 1.0
 */
package com.bean;

public class UserBean {
    public UserBean(){
        System.out.println("加载了UseBean类");
    }
    public void sayHi(String name){
        System.out.println("hello " + name);
    }
}
