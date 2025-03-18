package com.atguigu.rest.crud.vo.req;

import com.atguigu.rest.crud.annotation.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmployeeAddVo {
    @NotBlank(message = "员工姓名不能为空")
    private String name;

    @NotNull(message = "员工年龄不能为空")
    @Max(value = 150, message = "年龄不能超过150岁")
    @Min(value = 0, message = "年龄不能为负数")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    //性别：男或女
//    @Pattern(regexp = "^男$|^女$", message = "性别只能是男或女")
    //国际化：internationalization
    //中文网站：性别只能是男或女
    //英文网站：Gender must be one of : male or female
    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
