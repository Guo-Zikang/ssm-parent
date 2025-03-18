package com.atguigu.rest.crud.validator;

import com.atguigu.rest.crud.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return "男".equals(s) || "女".equals(s);
    }
}
