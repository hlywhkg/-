/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 14:57
 * @Version 1.0
 */
package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "student1")
public class Student {
    String name;
    int age;
    int id;
}
