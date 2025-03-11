package com.atguigu.springmvc01helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody //把返回值放到响应体中； 每次请求进来执行目标方法
    @RequestMapping("/hello")
    public String handle() {
        System.out.println("handle执行");
        return "Hello, Spring MVC! 你好~~~"; //默认返回值跳到一个页面
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String handle01() {
        System.out.println("handle01执行");
        return "handle01";
    }

    @ResponseBody
    @RequestMapping("/hell*")
    public String handle02() {
        System.out.println("handle02执行");
        return "handle02";
    }

    @ResponseBody
    @RequestMapping("/hell/**")
    public String handle03() {
        System.out.println("handle03执行");
        return "handle03";
    }
}
