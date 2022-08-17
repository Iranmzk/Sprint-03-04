package demo.sprint.service.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import demo.sprint.integration.walmart.WalmartIntegration;
import demo.sprint.model.walmartentity.ProductEntity;
import demo.sprint.repository.WalmartRepository;
import demo.sprint.service.walmart.mapper.response.DataServiceResponseMapper;
import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class WalmartService {

    private WalmartIntegration integration;
    private WalmartRepository repository;


    public Optional<ProductEntity> findByUsItemId(String usItemId) {
        return repository.findById(usItemId);
    }


    public ResponseServiceProduct findProductIntegration(String usItemId) {
        return Optional.ofNullable(integration.findProductDetails(usItemId))
                .map(productValidation())
                .map(DataServiceResponseMapper::toIntResponse)
                .map(repository::save)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseThrow(() -> new ApiNotFoundException("Please,insert a valid usItemId"));
    }


    private Function<DataIntegrationResponse, DataIntegrationResponse> productValidation() {
        return product -> {
            // A class that provides static utility methods for simple operations on objects.
            if (ObjectUtils.isEmpty(product.getData()
                    .getProduct())) {
                throw new ApiNotFoundException("Please,insert a valid usItemId");
            }
            return product;
        };
    }


    public List<ResponseServiceProduct> findAllProd(){
        return repository.findAll()
                .stream()
                .map(ProductEntityResponseMapper::toProductEntity)
                .toList();
    }


    public void deleteProdById(List<String> usItemId) {
        repository.deleteAllById(usItemId);
    }
}