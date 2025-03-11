package com.atguigu.spring02aop.log;

import java.util.Arrays;

public class LogUtils {
    public static void logStart(String name, Object... args) {
        System.out.println("【日志】 方法【" + name + "】开始；参数：" + Arrays.toString(args));
    }

    public static void logEnd(String name) {
        System.out.println("【日志】 方法【" + name + "】结束");
    }

    public static void logError(String name, Throwable e) {
        System.out.println("【日志】 方法【" + name + "】发生错误；错误信息：" + e.getCause());
    }

    public static void logReturn(String name, Object result) {
        System.out.println("【日志】 方法【" + name + "】返回；返回结果：" + result);
    }
}
