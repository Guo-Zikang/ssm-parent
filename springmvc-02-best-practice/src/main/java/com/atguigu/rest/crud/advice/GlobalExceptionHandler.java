package com.atguigu.rest.crud.advice;

import com.atguigu.rest.crud.common.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@ResponseBody
//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public R handleArithmeticException(ArithmeticException e) {
        System.out.println("【全局异常处理】 - ArithmeticException异常处理");
        return R.error(100, "发生异常" + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("【全局异常处理】 - MethodArgumentNotValidException异常处理");
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return R.error(500, "校验失败", errorMap);
    }

    @ExceptionHandler(Throwable.class)
    public R handleThrowable(Throwable e) {
        System.out.println("【全局异常处理】 - Throwable异常处理" + e.getClass());
        return R.error(500, "发生异常" + e.getMessage());
    }
}
