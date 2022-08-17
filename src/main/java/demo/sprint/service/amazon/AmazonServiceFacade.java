package demo.sprint.service.amazon;

import demo.sprint.service.amazon.model.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AmazonServiceFacade {

private final AmazonService service;

    public List<ProductService> findProductDetails(String name){
        return service.findProductIntegration(name);
    }
}
