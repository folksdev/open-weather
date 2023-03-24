package com.assignment.openweatherservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Open Weather Service API")
                        .version("1.0")
                        .description("""
                                This is an api provides weather report
                                for last 30 minutes based on city names
                                """
                        ));
    }

}
