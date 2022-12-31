package com.example.geoapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Entity
@Table(name = "coordinates")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private UUID deviceId;

    @NotBlank(message = "latitude can't be blank")
    private String latitude;
    @NotBlank(message = "longitude can't be blank")
    private String longitude;

}
