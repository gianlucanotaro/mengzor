package com.example.mengzor.config;

import org.springdoc.core.customizers.OpenApiCustomiser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Your API Title")
                        .version("Your API version")
                        .description("Your API description"));
    }

    // If you need to customize it further, you can use OpenApiCustomiser
    @Bean
    public OpenApiCustomiser sortTagsAlphabetically() {
        return openApi -> openApi.getPaths().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> openApi.path(entry.getKey(), entry.getValue()));
    }
}
