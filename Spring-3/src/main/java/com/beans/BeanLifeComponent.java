/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/4 12:57
 * @Version 1.0
 */
package com.beans;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeComponent implements BeanNameAware {

    @PostConstruct
    public void PostConstruct(){
        System.out.println("执行@PostConstruct");
    }

    public void init(){
        System.out.println("执行bean-init-method");
    }

    public void use(){
        System.out.println("正在使用bean");
    }

    @PreDestroy
    public void PreDestroy(){
        System.out.println("执行@PreDestroy");
    }

    public void setBeanName(String s){
        System.out.println("执行了Aware通知");
    }
}
