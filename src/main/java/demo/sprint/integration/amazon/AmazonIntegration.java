package demo.sprint.integration.amazon;

import demo.sprint.integration.amazon.model.DocsIntegration;
import demo.sprint.integration.amazon.model.DocsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@NoArgsConstructor
public class AmazonIntegration {
    @Qualifier("restTemplateBuilderAmazon")
    @Autowired
    private RestTemplate restTemplate;
    public DocsResponse findProdAmazon(String name) {
        return restTemplate.getForObject("/api/product?country=BR&keyword="
                .concat(name),DocsResponse.class);
    }
}

