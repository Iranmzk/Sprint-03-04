package demo.sprint.integration.data;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DataIntegration {
    RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("https://walmart.p.rapidapi.com/products/v3/")
            .defaultHeader("X-RapidAPI-Host", "walmart.p.rapidapi.com")
            .defaultHeader("X-RapidAPI-Key", "bdbd0f936bmshe7a392f9fa3452bp1f3ba9jsnfbe1a9455901")
            .build();

    public DataIntegrationResponse findProduct(String usItemId){
        return restTemplate.getForObject("get-details?usItemId=".concat(usItemId), DataIntegrationResponse.class);
    }
}
