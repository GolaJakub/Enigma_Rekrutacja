package com.example.geoapi.exception;

import java.util.NoSuchElementException;
import java.util.UUID;

public class DeviceNotFoundException extends NoSuchElementException {

    public DeviceNotFoundException(UUID deviceId){
        super("Device not found. Id: " + deviceId);
    }
}
