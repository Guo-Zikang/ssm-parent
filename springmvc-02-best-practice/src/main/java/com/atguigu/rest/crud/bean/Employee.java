package com.atguigu.rest.crud.bean;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {
    private Long id;

    @NotBlank(message = "员工姓名不能为空")
    private String name;

    @NotNull(message = "员工年龄不能为空")
    @Max(value = 150, message = "年龄不能超过150岁")
    @Min(value = 0, message = "年龄不能为负数")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
