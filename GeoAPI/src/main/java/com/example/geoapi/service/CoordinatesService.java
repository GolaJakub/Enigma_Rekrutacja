package com.example.geoapi.service;

import com.example.geoapi.exception.DeviceNotFoundException;
import com.example.geoapi.exception.InvalidCoordinatesException;
import com.example.geoapi.model.CoordinatesEntity;
import com.example.geoapi.repository.CoordinatesRepository;
import com.example.geoapi.validator.Coordinates;
import com.example.openapi.model.CoordinatesCreate;
import com.example.openapi.model.CoordinatesDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static com.example.geoapi.mapper.CoordinatesMapper.API_MAPPER;

@Service
@RequiredArgsConstructor
@Log4j2
public class CoordinatesService {

    private final CoordinatesRepository coordinatesRepository;


    public CoordinatesDetails getDeviceLocation(@NotNull UUID deviceId) {
        log.info("Getting location for device: " + deviceId);
        CoordinatesEntity coordinates = coordinatesRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));

        log.info("Got device coordinates {} ", coordinates);

        return API_MAPPER.toCoordinatesDetails(coordinates);
    }

    public CoordinatesDetails addDeviceLocation(@NotNull CoordinatesCreate coordinatesCreate) {
        log.info("Adding coordinates: {}",coordinatesCreate);

        if (isValid(coordinatesCreate)){
            CoordinatesEntity coordinatesEntity =
                    coordinatesRepository.save(API_MAPPER.toCoordinatesEntity(coordinatesCreate));

            log.info("Added device with id: {}", coordinatesEntity.getDeviceId());
            return API_MAPPER.toCoordinatesDetails(coordinatesEntity);

        }
        else{
            log.info("Invalid coordinates, can't add device location to database");
            throw new InvalidCoordinatesException();
        }

    }

    public String updateDeviceLocation(@NotNull UUID deviceId, @NotNull CoordinatesCreate coordinatesCreate) {
        log.info("Updating device with id: {}", deviceId);
        if (isValid(coordinatesCreate)){
            CoordinatesEntity coordinates = coordinatesRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
            coordinates.setLatitude(coordinatesCreate.getLatitude());
            coordinates.setLongitude(coordinatesCreate.getLongitude());
            coordinatesRepository.save(coordinates);
            log.info("Updated device with id: {}", deviceId);
            return "Updated device with id: " + deviceId;
        }
        else{
            log.info("Invalid coordinates, can't update device location in database");
            throw new InvalidCoordinatesException();
        }

    }
    //TODO ADNOTACJA


    public boolean isValid(CoordinatesCreate coordinatesCreate) {

        String latitude = coordinatesCreate.getLatitude();
        String longitude = coordinatesCreate.getLongitude();

        if (coordinatesCreate != null){
            return latitude.matches("^([+-])?(?:90(?:\\.0{1,6})?|((?:|[1-8])[0-9])(?:\\.[0-9]{1,6})?)$")
                    &&
                    longitude.matches("^([+-])?(?:180(?:\\.0{1,6})?|((?:|[1-9]|1[0-7])[0-9])(?:\\.[0-9]{1,6})?)$");
        }
        return true;
    }
}
