package demo.sprint.controller.product;

import demo.sprint.configuration.exception.ApiNotFoundException;
import demo.sprint.controller.product.model.mapper.ProductControllerResponseMapper;
import demo.sprint.controller.product.model.response.ProductControllerResponse;
import demo.sprint.service.data.DataServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;
@Component
@AllArgsConstructor
public class ControllerFacade {

    private DataServiceFacade facade;

    public ProductControllerResponse findProd(String usItemId){
        return Stream.of(facade.findProductDetails(usItemId))
                .map(ProductControllerResponseMapper::toControllerResponse)
                .findFirst()
                .orElseThrow(() -> new ApiNotFoundException(usItemId));
    }

}