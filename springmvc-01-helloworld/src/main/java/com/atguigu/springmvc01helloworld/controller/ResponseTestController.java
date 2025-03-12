package com.atguigu.springmvc01helloworld.controller;

import com.atguigu.springmvc01helloworld.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class ResponseTestController {
    @RequestMapping("/resp01")
    public Person resp01() {
        Person person = new Person();
        person.setUsername("zhangsan");
        person.setPassword("123456");
        person.setCellphone("12345678900");
        person.setAgreement(true);
        person.setSex("男");
        person.setHobby(new String[]{"篮球", "足球"});
        person.setGrade("三年级");
        return person;
    }

    /**
     * 将文件返回给浏览器
     */
    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\guozikang\\Desktop\\111.png");
        InputStreamResource resource = new InputStreamResource(inputStream);
        String encode = URLEncoder.encode("这是图片.png", "UTF-8");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(inputStream.available())
                .header("Content-Disposition", "attachment; filename=" + encode)
                .body(resource);
    }
}
