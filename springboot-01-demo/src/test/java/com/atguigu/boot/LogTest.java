package com.atguigu.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LogTest {
//    Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    void test01() {


        System.out.println("============");
        log.trace("追踪日志");
        log.debug("调试日志");
        log.info("信息日志");
        log.warn("警告日志");
        log.error("错误日志");
    }
}
