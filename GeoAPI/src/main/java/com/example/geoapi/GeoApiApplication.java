package com.example.geoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
@Configuration
public class GeoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoApiApplication.class, args);
    }

    @Bean
    public Docket get(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.geoapi"))
                .paths(PathSelectors.ant("/location/**"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo("Coordinates API",
                "Location API for EnigmaSOI",
                "1.0",
                "Terms of service",
                new Contact("Jakub", "https://github.com/GolaJakub", "GolaJakub@protonmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }


}
