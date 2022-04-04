package com.epam.demo.validation.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SpecialNameConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecialNameConstraint {
    String message() default "Special name must starts with SN_";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
