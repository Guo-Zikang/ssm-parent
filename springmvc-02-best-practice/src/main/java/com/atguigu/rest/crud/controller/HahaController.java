package com.atguigu.rest.crud.controller;

import com.atguigu.rest.crud.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HahaController {
    @GetMapping("/haha")
    public R haha() {
        int i = 10 / 0;
        return R.success();
    }
}
