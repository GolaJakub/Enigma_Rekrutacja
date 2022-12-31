package com.example.geoapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE, ElementType.METHOD, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CoordinatesValidator.class)
public @interface Coordinates {

String message() default "Invalid coordinates given!";

Class<?>[] groups() default {};

Class<? extends Payload>[] payload() default {};
}
