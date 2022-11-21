package demo.sprint.integration.walmart;

import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
@AllArgsConstructor
public class WalmartIntegration {
    private RestTemplate restTemplateWalmart;

    public DataIntegrationResponse findProductDetails(String usItemId){
        return restTemplateWalmart.getForObject("/products/v3/get-details?usItemId="
                                .concat(usItemId),DataIntegrationResponse.class);
    }
    @EventListener(ContextRefreshedEvent.class)
    public Optional<DataIntegrationResponse> createTest(){
        return Optional.of(findProductDetails("841765146"))
                .map(a -> a);
    }

}