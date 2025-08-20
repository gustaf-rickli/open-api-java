package com.dio.spring_tests.welcome_controller.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    private Contact contato() {
        return new Contact()
                .name("Gustavo Rickli")
                .url("https://www.linkedin.com/in/gustavo-rickli/")
                .email("gustavorickli.contato@gmail.com");
    }

    private Info informacoesApi() {
        return new Info()
                .title("Welcome API")
                .description("API exemplo de uso de Springboot REST API")
                .version("1.0")
                .termsOfService("Termo de uso: Open Source - MIT")
                .license(new License()
                        .name("")
                        .url(""))
                .contact(this.contato());
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(informacoesApi());
    }
}