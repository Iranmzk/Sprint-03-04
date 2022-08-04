package demo.sprint.service.data;

import demo.sprint.model.walmartEntity.ProductEntity;
import demo.sprint.service.data.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.data.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// A stereotype annotation that indicates that an annotated class is a "component". Such classes are considered as
// candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
@AllArgsConstructor
public class DataServiceFacade {

    private DataService service;
    // Looking for the product in the database, if it does not find it, it looks for it in the integration.
    public ResponseServiceProduct findProductDetails(String usItemId){
        return service.findByUsItemId(usItemId)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseGet(() -> service.findProductIntegration(usItemId));
    }

    public List<ResponseServiceProduct> findAllProd(){
        return service.findAllProd();
    }

    public void deleteProdById(List<String> usItemId){
        service.deleteProdById(usItemId);
    }

    public ProductEntity save(ProductEntity prod){
        return service.save(prod);
    }
}
