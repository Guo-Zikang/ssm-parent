package com.atguigu.spring02aop.proxy.dynamic;

import com.atguigu.spring02aop.log.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxy {
    public static Object getProxyInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                ((proxy, method, args) -> {
                    String name = method.getName();
                    // 记录开始
                    LogUtils.logStart(name, args);
                    Object result = null;
                    try {
                        result = method.invoke(target, args);
                        // 记录返回值
                        LogUtils.logReturn(name, result);
                    } catch (Exception e) {
                        LogUtils.logError(name, e);
                        //throw new Exception(e);
                    } finally {
                        LogUtils.logEnd(name);
                    }
                    return result;
                })
        );
    }
}
