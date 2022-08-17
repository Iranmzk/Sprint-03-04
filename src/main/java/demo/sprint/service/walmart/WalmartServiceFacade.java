package demo.sprint.service.walmart;

import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class WalmartServiceFacade {
    private WalmartService service;


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
}
