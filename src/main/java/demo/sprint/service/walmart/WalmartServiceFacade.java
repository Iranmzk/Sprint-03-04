package demo.sprint.service.walmart;

import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// A stereotype annotation that indicates that an annotated class is a "component". Such classes are considered as
// candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
@AllArgsConstructor
public class WalmartServiceFacade {
    private WalmartService service;
    /**
     * If the product is found in the database, return the product. If not, return the product from the integration
     *
     * @param usItemId The unique identifier of the product.
     * @return ResponseServiceProduct
     */
    public ResponseServiceProduct findProductDetails(String usItemId){
        return service.findByUsItemId(usItemId)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseGet(() -> service.findProductIntegration(usItemId));
    }
/* Not in use
    public List<ResponseServiceProduct> findAllProd(){
        return service.findAllProd();
    }
    */

    public void deleteProdById(List<String> usItemId){
        service.deleteProdById(usItemId);
    }
}
