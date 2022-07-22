package demo.sprint.configuration.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .rootUri("https://walmart.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Host", "walmart.p.rapidapi.com")
                .defaultHeader("X-RapidAPI-Key", "bdbd0f936bmshe7a392f9fa3452bp1f3ba9jsnfbe1a9455901")
//                .errorHandler(new DefaultResponseErrorHandler())
                .build();
    }
}
    /*
    @Bean é usado quando você precisa explicitamente configurar o bean
    ao invés de deixar o spring automaticamente fazer, como por exemplo @Service, @Component, @Repository
    Sempre que você estiver usando a anotação @Bean para criar o bean
    não precisará usar a anotação @ComponentScan dentro de sua classe de configuração.
     */