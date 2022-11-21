package demo.sprint.configuration.rest;

import demo.sprint.configuration.exception.apiexterror.ApiErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// A class-level annotation indicating that a class declares one or more @Bean methods and may be processed by the Spring
// container to generate bean definitions and service requests for those beans at runtime.
@Configuration
public class RestConfig {
    @Value("${apiKey}")
    private String apiKey;
    @Value("${apiKeyRespond}")
    private String apiKeyRespond;
    @Value("${apiHost}")
    private String apiHost;
    @Value("${apiHostRespond}")
    private String apiHostRespond;

    @Bean
    public RestTemplate restTemplateWalmart() {
        return new RestTemplateBuilder()
                .rootUri("https://walmart.p.rapidapi.com")
                .defaultHeader(apiHost, apiHostRespond)
                .defaultHeader(apiKey, apiKeyRespond)
                .errorHandler(new ApiErrorHandler())
                .build();
    }

    @Bean
    public RestTemplate restTemplateBuilderAmazon() {
        return new RestTemplateBuilder()
                .rootUri("https://amazon24.p.rapidapi.com")
                .defaultHeader(apiHost, apiHostRespond)
                .defaultHeader(apiKey, apiKeyRespond)
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