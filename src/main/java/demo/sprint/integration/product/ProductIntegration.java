package demo.sprint.integration.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ProductIntegration {
   @Autowired
    RestTemplate restTemplate;

    public ProductIntegrationResponse findProduct(String usItemId){
        return restTemplate.getForObject("/get-details?usItemId=".concat(usItemId), ProductIntegrationResponse.class);
    }
}
