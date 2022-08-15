/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/15 19:45
 * @Version 1.0
 */
package com.example.demo.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@ResponseBody
public class User2 {
    @RequestMapping("/say")
    public void say(){
        log.trace("我是trace");
        log.debug("我是debug");
        log.info("我是info");
        log.warn("我是warn");
        log.error("我是error");
    }
}
