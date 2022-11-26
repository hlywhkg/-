/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/26 14:47
 * @Version 1.0
 */
package com;

import java.util.Random;

public class getParameter {
    private String[] nameLogin = new String[]{"zhangsan","张三","sjw","wangwu"};
    private String[] nameRegister = new String[]{"李四","王五","哈哈","呵呵"};

    public String getLoginName(){
        int index = (int)(Math.random()*nameLogin.length);
        return nameLogin[index];
    }

    public String getRegisterName(){
        int index = (int)(Math.random()*nameRegister.length);
        return nameRegister[index];
    }

    public int getIndex(){
        return (int)(Math.random()*10);
    }

}
