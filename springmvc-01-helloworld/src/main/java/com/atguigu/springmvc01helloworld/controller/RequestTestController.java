package com.atguigu.springmvc01helloworld.controller;

import com.atguigu.springmvc01helloworld.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class RequestTestController {

    /**
     * username=zhangsan&password=123456&cellphone=12345678900&agreement=on
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(String username, String password, String cellphone, boolean agreement) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "ok";
    }

    /**
     * username=zhangsan&password=123456&cellphone=12345678900&agreement=on
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password", defaultValue = "123456") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam(value = "agreement", required = false) boolean ok) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(phone);
        System.out.println(ok);
        return "ok";
    }

    /**
     * pojo
     * @param person
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(Person person) {
        System.out.println(person);
        return "ok";
    }

    /**
     * 获取请求头信息
     */
    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host,
                           @RequestHeader("user-agent") String userAgent) {
        System.out.println(host);
        System.out.println(userAgent);
        return "ok " + host;
    }

    /**
     * 获取cookie
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("haha") String haha) {
        System.out.println(haha);
        return "ok, cookie: " + haha;
    }

    @RequestMapping("/handle06")
    public String handle06(Person person) {
        System.out.println(person);
        return "ok";
    }

    @RequestMapping("/handle07")
    public String handle07(@RequestBody Person person) {
        System.out.println(person);
        return "ok";
    }

    /**
     * 文件上传
     * @param person
     * @return
     */
    @RequestMapping("/handle08")
    public String handle08(Person person,
                           @RequestParam("headerImg") MultipartFile headerImgFile,
                           @RequestParam("lifeImg") MultipartFile[] lifeImgFiles) throws IOException {
        System.out.println(person);

        //1. 获取原始文件名
        String headerImgFileName = headerImgFile.getOriginalFilename();
        System.out.println("headerImgFileName: " + headerImgFileName);

        //2. 获取文件大小
        long headerImgSize = headerImgFile.getSize();
        System.out.println("headerImgSize: " + headerImgSize);
        //3. 获取文件流
        InputStream inputStream = headerImgFile.getInputStream();
        System.out.println(inputStream);
        //4. 保存文件
        headerImgFile.transferTo(new File("C:\\Users\\guozikang\\Desktop\\" + headerImgFileName));
        System.out.println("=======以上处理了头像========");

        if (lifeImgFiles.length > 0) {
            //保存文件
            for (MultipartFile lifeImgFile : lifeImgFiles) {
                String lifeImgFileName = lifeImgFile.getOriginalFilename();
                System.out.println("lifeImgFileName: " + lifeImgFileName);
                lifeImgFile.transferTo(new File("C:\\Users\\guozikang\\Desktop\\" + lifeImgFileName));
            }
        }
        return "ok!!!";
    }

    @RequestMapping("/handle09")
    public String handle09(HttpEntity<Person> entity) {
        //1. 获取请求头
        HttpHeaders headers = entity.getHeaders();
        System.out.println("请求头" + headers);
        //2. 获取请求体
        Person body = entity.getBody();
        System.out.println("请求体" + body);
        return "ok~~~";
    }

    @RequestMapping("/handle10")
    public void handle10(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().write("ok~~~" + username);
    }
}
