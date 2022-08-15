/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/15 14:39
 * @Version 1.0
 */
package com.example.demo.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class User {
    private Logger logger = LoggerFactory.getLogger(User.class);
    @RequestMapping("/logger")
    public void say(){
        logger.trace("我是trace");
        logger.debug("我是debug");
        logger.info("我是info");
        logger.warn("我是warn");
        logger.error("我是error");
    }
}
