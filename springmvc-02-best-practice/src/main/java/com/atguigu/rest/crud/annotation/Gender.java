package com.atguigu.rest.crud.annotation;

import com.atguigu.rest.crud.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {GenderValidator.class}
)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {
    String message() default "{jakarta.validation.constraints.Email.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
