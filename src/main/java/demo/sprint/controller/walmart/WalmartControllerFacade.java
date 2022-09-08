package demo.sprint.controller.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.controller.walmart.model.mapper.ProductControllerResponseMapper;
import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;
import demo.sprint.service.walmart.WalmartServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
@AllArgsConstructor
public class WalmartControllerFacade {
    private WalmartServiceFacade facade;

    /**
     * > It takes a String, calls a facade, maps the result to a controller response, and returns it
     *
     * @param usItemId The unique identifier for the product.
     * @return ProductControllerResponse
     */
    public ProductControllerResponse findProductDetails(String usItemId) {
        return Stream.of(facade.findProductDetails(usItemId))
                .map(ProductControllerResponseMapper::toControllerResponse)
                .findFirst()
                .orElseThrow(() -> new ApiNotFoundException("Not found"));
    }

    public void deleteProdById(List<String> usItemId) {
        facade.deleteProdById(usItemId);
    }

    public Page<ProductControllerResponse> findAllProd(Pageable pageable) {
        return facade.findAllProd(pageable)
                .map(ProductControllerResponseMapper::toControllerResponse);
    }

    public List<ProductControllerResponse> findByName(String name) {
        return facade.findByName(name)
                .stream()
                .map(ProductControllerResponseMapper::toControllerResponse)
                .collect(Collectors.toList());
    }

    public List<ProductControllerResponse> find(ProductQuery productQuery){
        return facade.find(productQuery)
                .stream()
                .map(ProductControllerResponseMapper::toControllerResponse)
                .collect(Collectors.toList());
    }

}

