package demo.sprint.service.walmart;

import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ResponseServiceProduct> findByName(String name, Pageable pageable){
        return service.findByNameEntity(name,pageable)
                .map(ProductEntityResponseMapper::toProductEntity);
    }

    public Page<ResponseServiceProduct> findAllProd(Pageable pageable){
        return service.findAllProd(pageable);
    }

//    public List<ResponseServiceProduct> findByName(String name){
//        return service.findByName(name);
//    }


    public void deleteProdById(List<String> usItemId){
        service.deleteProdById(usItemId);
    }
}
