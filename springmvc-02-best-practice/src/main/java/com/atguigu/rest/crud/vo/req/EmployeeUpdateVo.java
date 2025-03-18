package com.atguigu.rest.crud.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Schema(description = "修改员工需要提交的数据")
@Data
public class EmployeeUpdateVo {
    @Schema(description = "员工id")
    @NotNull(message = "员工id不能为空")
    private Long id;

    @Schema(description = "员工姓名")
    private String name;

    @Schema(description = "员工年龄")
    private Integer age;

    @Schema(description = "员工邮箱")
    private String email;

    @Schema(description = "员工性别")
    private String gender;

    @Schema(description = "员工地址")
    private String address;

    @Schema(description = "员工薪资")
    private BigDecimal salary;

    @Schema(description = "员工生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
