package com.andersonmesq.customer_service.shared.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TorqueDesk API")
                        .description("API for workshop management")
                        .version("v1"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }

    @Bean
    public GroupedOpenApi customerApi(){
        return GroupedOpenApi.builder()
                .group("4 - Customers")
                .pathsToMatch("/api/v1/customers/**")
                .build();
    }

    @Bean
    public GroupedOpenApi vehicleApi(){
        return GroupedOpenApi.builder()
                .group("5 - Vehicles")
                .pathsToMatch("/api/v1/vehicles/**")
                .build();
    }
}