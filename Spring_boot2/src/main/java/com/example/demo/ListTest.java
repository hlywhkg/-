/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/14 15:10
 * @Version 1.0
 */
package com.example.demo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties("dbtypes1")
@Component
public class ListTest {
    List<String> name;
}
