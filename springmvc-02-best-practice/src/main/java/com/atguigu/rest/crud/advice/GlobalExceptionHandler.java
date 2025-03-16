package com.atguigu.rest.crud.advice;

import com.atguigu.rest.crud.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ResponseBody
//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public R handleArithmeticException(ArithmeticException e) {
        System.out.println("【全局异常处理】 - ArithmeticException异常处理");
        return R.error(100, "发生异常" + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public R handleThrowable(Throwable e) {
        System.out.println("【全局异常处理】 - Throwable异常处理");
        return R.error(500, "发生异常" + e.getMessage());
    }
}
