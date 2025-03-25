package com.atguigu.mybatis;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PageTest {
    @Autowired
    EmpService empService;

    @Test
    void Test01() {
        PageHelper.startPage(1, 5);
        List<Emp> all = empService.getAll();

        PageInfo<Emp> pageInfo = new PageInfo<>(all);
        //当前第几页
        System.out.println("当前页码" + pageInfo.getPageNum());
        //总页码
        System.out.println("总页码" + pageInfo.getPages());
        //总记录数
        System.out.println("总记录数" + pageInfo.getTotal());
        //有没有下一页
        System.out.println("有没有下一页" + pageInfo.isHasNextPage());
        //有没有上一页
        System.out.println("有没有上一页" + pageInfo.isHasPreviousPage());
        //本页数据
        System.out.println("本页数据" + pageInfo.getList());
    }
}
