package com.example.geoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidCoordinatesAdvice {


    @ResponseBody
    @ExceptionHandler(InvalidCoordinatesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidCoordinatesFormat(InvalidCoordinatesException ex){
        return ex.getMessage();
    }

}
