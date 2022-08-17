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
//                .map(productValidation())
//                .map(IntegrationToServiceResponse::toEntityMapper)
//                .map(amazonRepository::save)
//                .map(EntityToServiceResponse::toServiceResponse)
//                .orElseThrow(() -> new ApiNotFoundException("Name not found"));

//    private Function<DocsResponse, DocsResponse> productValidation() {
//        return product -> {
//            // A class that provides static utility methods for simple operations on objects.
//            if (ObjectUtils.isEmpty(Arrays.stream(product.getProductsAmazon())
//                    .map(DocsIntegration::getName))) {
//                throw new ApiNotFoundException("Please,insert a valid product");
//            }
//            return product;
//        };
//    }

