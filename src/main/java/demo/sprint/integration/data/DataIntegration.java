package demo.sprint.integration.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class DataIntegration {
    private final RestTemplate restTemplate;

    public DataIntegrationResponse findProduct(String usItemId){
        return restTemplate.getForObject("/products/v3/get-details?usItemId=" + usItemId, DataIntegrationResponse.class);
    }
}
