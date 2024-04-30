package com.example.order.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(apiInfo())
                ;
    }


    private Info apiInfo() {
        return new Info()
                .title("swagger 테스트")
                .description("Springdoc - Swagger UI")
                .version("2.0.0");
    }

}
