package demo.sprint.integration.walmart;

import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
//@NoArgsConstructor
public class WalmartIntegration {
    @Qualifier("restTemplateWalmart")
    @Autowired
    private RestTemplate restTemplate;

    public DataIntegrationResponse findProductDetails(String usItemId){
        return restTemplate.getForObject("/products/v3/get-details?usItemId=".concat(usItemId), DataIntegrationResponse.class);
    }
}
//TODO: INTEGRAR OUTRA APLICAÇÃO -
//TODO: MONGOTEMPLATE/QUERY DATAS -
//TODO: ESTUDAR PROPERTIES DO SPRING -