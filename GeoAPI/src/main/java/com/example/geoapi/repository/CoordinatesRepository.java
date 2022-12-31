package com.example.geoapi.repository;

import com.example.geoapi.model.CoordinatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, UUID> {
}
