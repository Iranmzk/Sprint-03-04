package demo.sprint.configuration.rest;

import demo.sprint.configuration.exception.apiexterror.ApiErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

 // A class-level annotation indicating that a class declares one or more @Bean methods and may be processed by the Spring
// container to generate bean definitions and service requests for those beans at runtime.
@Configuration
public class RestConfig {

//TODO: DEFINIR HEADER PROPRIEDADES SPRING, CLASSE ENVIRONMENT

    @Bean
    public RestTemplate restTemplateWalmart() {
        return new RestTemplateBuilder()
                .rootUri("https://walmart.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Host", "walmart.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Key", "bdbd0f936bmshe7a392f9fa3452bp1f3ba9jsnfbe1a9455901")
                .errorHandler(new ApiErrorHandler())
                .build();
    }
     @Bean
     public RestTemplate restTemplateBuilderAmazon() {
        return new RestTemplateBuilder()
                .rootUri("https://amazon24.p.rapidapi.com")
                 .defaultHeader("X-RapidAPI-Host", "amazon24.p.rapidapi.com")
                 .defaultHeader("X-RapidAPI-Key", "bdbd0f936bmshe7a392f9fa3452bp1f3ba9jsnfbe1a9455901")
                 .errorHandler(new ApiErrorHandler())
                 .build();
     }
 }
/*
    @Bean é usado quando você precisa explicitamente configurar o bean
    ao invés de deixar o spring automaticamente fazer, como por exemplo @Service, @Component, @Repository
    Sempre que você estiver usando a anotação @Bean para criar o bean
    não precisará usar a anotação @ComponentScan dentro de sua classe de configuração.
     */