package com.example.rest.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtilRealization implements ValidationUtil{
    private final jakarta.validation.Validator validator;

    @Autowired
    public ValidationUtilRealization(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> boolean isValid(E object) {
        return this.validator.validate(object).size() == 0;
    }
    @Override
    public <E>Set<ConstraintViolation<E>> violations(E object){
        return this.validator.validate(object);
    }
}
