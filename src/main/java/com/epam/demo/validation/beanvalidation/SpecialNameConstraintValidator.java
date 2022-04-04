package com.epam.demo.validation.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SpecialNameConstraintValidator implements ConstraintValidator<SpecialNameConstraint, String> {
    @Override
    public void initialize(SpecialNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.startsWith("SN_");
    }
}
