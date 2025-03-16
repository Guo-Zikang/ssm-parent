package com.atguigu.rest.crud.controller;

import com.atguigu.rest.crud.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 测试声明式异常处理
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public R hello(@RequestParam(value = "i", defaultValue = "0") Integer i) throws FileNotFoundException {
        int j = 10 / i;
        //FileInputStream file = new FileInputStream("d:/xxx.txt");
        String s = null;
        s.length();
        return R.success(j);
    }

    @ExceptionHandler(ArithmeticException.class)
    public R handleArithmeticException(ArithmeticException e) {
        System.out.println("【本类】 - ArithmeticException异常处理");
        return R.error(100, "发生异常" + e.getMessage());
    }

    @ExceptionHandler(FileNotFoundException.class)
    public R handleFileNotFoundException(FileNotFoundException e) {
        System.out.println("【本类】 - FileNotFoundException异常处理");
        return R.error(300, "发生异常" + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public R handleException(Throwable e) {
        System.out.println("【本类】 - Throwable异常处理");
        return R.error(500, "发生异常" + e.getMessage());
    }

}
