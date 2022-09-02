package demo.sprint.integration.walmart;

import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@AllArgsConstructor
public class WalmartIntegration {
    private RestTemplate restTemplateWalmart;

    public DataIntegrationResponse findProductDetails(String usItemId){
        return restTemplateWalmart.getForObject("/products/v3/get-details?usItemId="
                                .concat(usItemId),DataIntegrationResponse.class);
    }
}