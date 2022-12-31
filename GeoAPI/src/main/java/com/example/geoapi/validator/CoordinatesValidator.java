package com.example.geoapi.validator;

import com.example.openapi.model.CoordinatesCreate;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CoordinatesValidator implements ConstraintValidator<Coordinates, CoordinatesCreate> {

    @Override
    public void initialize(Coordinates constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CoordinatesCreate coordinatesCreate, ConstraintValidatorContext constraintValidatorContext) {

/*        String latitude = coordinatesCreate.getLatitude();
        String longitude = coordinatesCreate.getLongitude();

        if (coordinatesCreate != null){
            return latitude.matches("^([+-])?(?:90(?:\\.0{1,6})?|((?:|[1-8])[0-9])(?:\\.[0-9]{1,6})?)$")
                    &&
                    longitude.matches("^([+-])?(?:180(?:\\.0{1,6})?|((?:|[1-9]|1[0-7])[0-9])(?:\\.[0-9]{1,6})?)$");
        } else {
            throw new InvalidCoordinatesException();
        }*/
        return false;
    }
}
