package com.brainstation_23.LibraryManagementSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 Library Management System API")
                        .version("1.0")
                        .description("API documentation for managing books, users, borrowing, reviews, and more."));
    }
}
