package com.example.geoapi.controller;


import com.example.geoapi.service.CoordinatesService;
import com.example.openapi.api.LocationApi;
import com.example.openapi.model.CoordinatesCreate;
import com.example.openapi.model.CoordinatesDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
public class CoordinatesController implements LocationApi {

    private CoordinatesService coordinatesService;

    @Override
    public ResponseEntity<CoordinatesDetails> getDeviceLocation(@NotNull UUID deviceId) {
        return ok(coordinatesService.getDeviceLocation(deviceId));
    }

    @Override
    public ResponseEntity<CoordinatesDetails> addDeviceLocation(@NotNull CoordinatesCreate coordinatesCreate) {
        return ok(coordinatesService.addDeviceLocation(coordinatesCreate));
    }

    @Override
    public ResponseEntity<String> updateDeviceLocation(@NotNull UUID deviceId, @NotNull CoordinatesCreate coordinatesCreate) {
        return ok(coordinatesService.updateDeviceLocation(deviceId, coordinatesCreate));
    }
}
