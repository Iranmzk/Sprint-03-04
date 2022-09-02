package demo.sprint.service.amazon;

import demo.sprint.integration.amazon.AmazonIntegration;
import demo.sprint.service.amazon.model.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static demo.sprint.service.amazon.mapper.IntegrationToServiceResponse.toServiceMapper;

@Service
@AllArgsConstructor
public class AmazonService {

    private final AmazonIntegration integration;

    public List<ProductService> findProductIntegration(String name) {
        return toServiceMapper(integration.findProdAmazon(name));
    }
}

