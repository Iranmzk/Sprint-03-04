package demo.sprint.integration.amazon;

import demo.sprint.integration.amazon.model.DocsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class AmazonIntegration {

    private RestTemplate restTemplateBuilderAmazon;

// A constructor injection.
//    public AmazonIntegration(@Qualifier("restTemplateBuilderAmazon") RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public DocsResponse findProdAmazon(String name) {
        return restTemplateBuilderAmazon.getForObject("/api/product?country=BR&keyword="
                .concat(name),DocsResponse.class);
    }
}
