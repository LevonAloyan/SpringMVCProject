package com.epam.demo.validation.springvalidation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof Person) {
            ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
            Person p = (Person) target;
            if (p.getAge() < 0) {
                errors.rejectValue("age", "negative.value");
            } else if (p.getAge() > 110) {
                errors.rejectValue("age", "too.darn.old");
            }
        }

    }
}
