package com.example.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
*Configuration Swagger to generate documentation of REST api
 * HTML: http://localhost:8080/swagger-ui/
**/
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails (){
        return new ApiInfo("Spring Boot Book API REST", "Library API rest docs", "1.0", "http://www.google.com", new Contact("Alan", "http://www.google.com", "sara@example.com"), "MIT", "http://www.google.com", Collections.emptyList());
    }


}
