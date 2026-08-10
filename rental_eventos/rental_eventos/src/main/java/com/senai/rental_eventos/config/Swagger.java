package com.senai.rental_eventos.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title="rental-api",
        version="1.0",
        description = "Dupla: Pedro Francisco e João pedro Miranda"
    )
)

public class Swagger {
    
}