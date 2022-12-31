package com.example.geoapi.mapper;

import com.example.geoapi.model.CoordinatesEntity;
import com.example.geoapi.validator.Coordinates;
import com.example.openapi.model.CoordinatesCreate;
import com.example.openapi.model.CoordinatesDetails;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, builder = @Builder(disableBuilder = true))
public interface CoordinatesMapper {

    CoordinatesMapper API_MAPPER = Mappers.getMapper(CoordinatesMapper.class);


    CoordinatesDetails toCoordinatesDetails(CoordinatesEntity coordinatesEntity);

    CoordinatesEntity toCoordinatesEntity(CoordinatesDetails coordinatesDetails);

    CoordinatesCreate toCoordinatesCreate(CoordinatesDetails coordinatesDetails);

    @Mapping(target = "deviceId", ignore = true)
    CoordinatesDetails toCoordinatesDetails(CoordinatesCreate coordinatesCreate);

    @Mapping(target = "deviceId", ignore = true)
    CoordinatesEntity toCoordinatesEntity(CoordinatesCreate coordinatesCreate);
}
