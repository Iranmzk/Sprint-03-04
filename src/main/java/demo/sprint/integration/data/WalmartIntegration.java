package demo.sprint.integration.data;

import demo.sprint.integration.data.model.DataIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class WalmartIntegration {
    private RestTemplate restTemplate;

    public DataIntegrationResponse find(String usItemId){
        return restTemplate.getForObject("/products/v3/get-details?usItemId=".concat(usItemId), DataIntegrationResponse.class);
    }
}
