package demo.sprint.service.product;

import demo.sprint.service.data.model.response.DataServiceResponse;
import demo.sprint.service.product.model.response.ProductServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductServiceFacade {
    private final ProductService service;


}
