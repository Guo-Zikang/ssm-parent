package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpReturnValueMapper {

    Long countEmp();

    BigDecimal getEmpSalaryById(Integer id);

    // 查询所有员工
    List<Emp> getAll();

    // 查询所有员工返回Map
    @MapKey("id")
    Map<Integer, Emp> getAllEmpMap();

    // 根据id查询员工
    Emp getEmpById(Integer id);
}
