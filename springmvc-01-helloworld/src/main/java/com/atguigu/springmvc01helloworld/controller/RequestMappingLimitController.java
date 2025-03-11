package com.atguigu.springmvc01helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingLimitController {

    /**
     * 请求方式
     * @return
     */
    @RequestMapping(value = "/test01", method = {RequestMethod.POST, RequestMethod.GET})
    public String test01() {
        return "hello world";
    }

    /**
     * 请求参数
     * @return
     */
    @RequestMapping(value = "/test02", params = {"age=18", "username"})
    public String test02() {
        return "test02";
    }

    /**
     * 请求头
     * @return
     */
    @RequestMapping(value = "/test03", headers = "haha")
    public String test03() {
        return "test03";
    }

    /**
     * 请求内容类型
     * @return
     */
    @RequestMapping(value = "/test04", consumes = "application/json")
    public String test04() {
        return "test04";
    }

    /**
     * 响应内容类型
     * @return
     */
    @RequestMapping(value = "/test05", produces = "text/html;charset=utf-8")
    public String test05() {
        return "<h1>我是标题</h1>";
    }
}
