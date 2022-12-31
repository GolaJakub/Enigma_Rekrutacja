package com.example.geoapi.controller;

import com.example.geoapi.service.CoordinatesService;
import com.example.openapi.model.CoordinatesCreate;
import com.example.openapi.model.CoordinatesDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CoordinatesController.class)
public class CoordinatesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CoordinatesService coordinatesService;

    private static final CoordinatesCreate coordinatesCreate = new CoordinatesCreate();
    private static final CoordinatesDetails coordinatesDetails = new CoordinatesDetails();

    private static final CoordinatesCreate coordinatesToUpdate = new CoordinatesCreate();
    @BeforeAll
    static void beforeTest(){
        coordinatesCreate.setLatitude("85");
        coordinatesCreate.setLongitude("120");
        coordinatesDetails.setLatitude("85");
        coordinatesDetails.setLongitude("120");
        coordinatesDetails.setDeviceId(UUID.fromString("f84a619c-7a88-4c08-aa6d-de5a20e45293"));
        coordinatesToUpdate.setLatitude("65");
        coordinatesToUpdate.setLongitude("150");
    }

    @Test
    public void getDeviceLocation() throws Exception {
        when(coordinatesService.getDeviceLocation(coordinatesDetails.getDeviceId()))
                .thenReturn(coordinatesDetails);

        RequestBuilder request = MockMvcRequestBuilders.get("/location/"+coordinatesDetails.getDeviceId());
        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        String jsonDetails = new ObjectMapper().writeValueAsString(coordinatesDetails);

        Assertions.assertEquals(jsonDetails, result.getResponse().getContentAsString());
    }


    @Test
    public void addDeviceLocation() throws Exception {
        when(coordinatesService.addDeviceLocation(coordinatesCreate))
                .thenReturn(coordinatesDetails);


        RequestBuilder request = MockMvcRequestBuilders.post("/location/add")
                .content(new ObjectMapper().writeValueAsString(coordinatesCreate))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        String jsonDetails = new ObjectMapper().writeValueAsString(coordinatesDetails);

        Assertions.assertEquals(jsonDetails, result.getResponse().getContentAsString());
    }

    @Test
    public void updateDeviceLocation() throws Exception {
        when(coordinatesService.updateDeviceLocation(coordinatesDetails.getDeviceId(), coordinatesToUpdate))
                .thenReturn("Updated device with id: " + coordinatesDetails.getDeviceId());


        RequestBuilder request = MockMvcRequestBuilders.put("/location/"+coordinatesDetails.getDeviceId())
                .content(new ObjectMapper().writeValueAsString(coordinatesToUpdate))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("Updated device with id: " + coordinatesDetails.getDeviceId(), result.getResponse().getContentAsString());
    }
}