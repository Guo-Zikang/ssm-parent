package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface EmpDynamicSQLMapper {
    //按照name和salary查询员工信息
    List<Emp> getEmpByNameAndSalary(@Param("name") String name,
                                    @Param("salary") BigDecimal salary);

    void updateEmp(Emp emp);

    List<Emp> getEmpByNameAndSalaryWhen(@Param("name") String name,
                                    @Param("salary") BigDecimal salary);

    // 查询指定id集合中的员工信息
    List<Emp> getEmpsByIdIn(@Param("ids") List<Integer> ids);
}
