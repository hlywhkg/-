/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/8/16 19:25
 * @Version 1.0
 */
package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@ResponseBody
@Slf4j
public class Upload {
    @RequestMapping("/upload")
    public boolean upload(@RequestPart("img")MultipartFile file){
        boolean result = false;
        //先获取的是文件整的名字，包括后缀
        String fileName = file.getOriginalFilename();
        //截取文件名最后一个 . 后面所有的字符，即后缀名
        fileName = fileName.substring(fileName.lastIndexOf("."));
        //UUID是一个永不会重复的id，具体可以网上找找
        //使用它的原因是因为当我们重复上传文件时可能会有重复的文件名
        //我们将文件名修改为不会重复的，从而达到能上传多次的效果
        fileName = UUID.randomUUID().toString() + fileName;
        //上传文件可能会失败，触发一个IOE异常，捕获一下
        try {
            file.transferTo(new File("C:/img/" + fileName));
            result = true;
        }catch (IOException e){
            //上传文件失败后，记录下日志
            log.error("上传文件失败");
        }
        return result;
    }
}
