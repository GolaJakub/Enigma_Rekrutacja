package com.example.geoapi.exception;

public class InvalidCoordinatesException extends IllegalArgumentException{

    public InvalidCoordinatesException(){
        super("Invalid coordinates given");
    }
}
