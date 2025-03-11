package com.atguigu.springmvc01helloworld.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
