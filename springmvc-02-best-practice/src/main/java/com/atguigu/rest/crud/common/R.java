package com.atguigu.rest.crud.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "统一返回结果")
public class R<T> {
    @Schema(description = "业务的状态码")
    private Integer code;

    @Schema(description = "提示信息")
    private String msg;

    @Schema(description = "数据")
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
