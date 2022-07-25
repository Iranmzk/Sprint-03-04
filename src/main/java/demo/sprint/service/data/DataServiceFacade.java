package demo.sprint.service.data;

import demo.sprint.service.data.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.data.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataServiceFacade {

    private DataService service;

    public ResponseServiceProduct findProductDetails(String usItemId){
        return service.findByUsItemId(usItemId)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseGet(() -> service.findProductIntegration(usItemId));
    }

    public void deleteProdById(List<String> usItemId){
        service.deleteProdById(usItemId);
    }
}
