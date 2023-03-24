package com.assignment.openweatherservice.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CityParameterValidator implements ConstraintValidator<CityNameConstraint, String> {

    private static final Logger logger = LoggerFactory.getLogger(CityParameterValidator.class);

    @Override
    public void initialize(CityNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        value = value.replaceAll("[^a-zA-Z0-9]", "");
        boolean isValid = !StringUtils.isNumeric(value) && !StringUtils.isAllBlank(value);
        if (!isValid) {

            context.buildConstraintViolationWithTemplate(value).addConstraintViolation();
            logger.info("The city parameter is not valid. value:" + value);
        }
        return !StringUtils.isNumeric(value) && !StringUtils.isAllBlank(value);
    }
}
