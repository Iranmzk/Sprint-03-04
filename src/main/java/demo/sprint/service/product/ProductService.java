package demo.sprint.service.product;

import demo.sprint.integration.product.ProductIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductIntegration integration;

//    public Optional<ProductServiceResponse> findProduct(String usItemId){
//        return Optional.of(integration.findProduct(usItemId))
//                .map(ProductIntegrationResponseMapper::prodServiceResponse);
//    }

}
