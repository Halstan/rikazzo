package com.rikazzo.rikazzo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                .basePackage("com.rikazzo.rikazzo.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiDetail());
    }

    private ApiInfo apiDetail(){
        return new ApiInfo(
                "Rikazzo API documentation",
                "Documentación para el proyecto de Modelos calidad de Software y Aplicaciones con enfoque orientado " +
                        "a servicios",
                "2.1",
                "Project - Free to use",
                new Contact("Rikazzo", "https://github.com/Halstan/rikazzo", "enzoarauco@gmail.com"),
                "MIT License",
                "",
                Collections.emptyList());
    }

}
