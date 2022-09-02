package demo.sprint.service.walmart;

import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class WalmartServiceFacade {
    private WalmartService service;


    public ResponseServiceProduct findProductDetails(String usItemId){
        return service.findByUsItemId(usItemId)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseGet(() -> service.findProductIntegration(usItemId));
    }

    public List<ResponseServiceProduct> findByName(String name){
        return service.findByNameEntity(name)
                .stream()
                .map(ProductEntityResponseMapper::toProductEntity)
                .collect(Collectors.toList());
    }

    public Page<ResponseServiceProduct> findAllProd(Pageable pageable){
        return service.findAllProd(pageable);
    }

    public void deleteProdById(List<String> usItemId){
        service.deleteProdById(usItemId);
    }

    public List<ResponseServiceProduct> find(String usItemId, String name, String segement, String type){
        return service.find(usItemId, name, segement, type);
    }

}
