package com.atguigu.rest.crud.common;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static R success() {
        R r = new R<>();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static R error() {
        R r = new R<>();
        r.setCode(500);
        r.setMsg("error");
        return r;
    }

    public static R error(Integer code, String msg) {
        R r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R error(Integer code, String msg, Object data) {
        R r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
