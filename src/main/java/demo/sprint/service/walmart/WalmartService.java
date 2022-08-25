package demo.sprint.service.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.walmart.WalmartIntegration;
import demo.sprint.repository.WalmartRepository;
import demo.sprint.repository.model.walmartentity.ProductEntity;
import demo.sprint.service.walmart.mapper.response.DataServiceResponseMapper;
import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static demo.sprint.configuration.exception.apiexterror.ApiErrorHandler.productValidation;

@Service
@AllArgsConstructor
public class WalmartService {

    private WalmartIntegration integration;
    private WalmartRepository repository;

    public Optional<ProductEntity> findByUsItemId(String usItemId) {
        return repository.findById(usItemId);
    }

    public Page<ProductEntity> findByNameEntity(String name, Pageable pageable) {
        return repository.findByName(name, pageable);
    }

    public ResponseServiceProduct findProductIntegration(String usItemId) {
        return Optional.ofNullable(integration.findProductDetails(usItemId))
                .map(productValidation())
                .map(DataServiceResponseMapper::toIntResponse)
                .map(repository::save)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseThrow(() -> new ApiNotFoundException("not found"));
    }

    public Page<ResponseServiceProduct> findAllProd(Pageable pageable){
        return repository.findAll(pageable)
                .map(ProductEntityResponseMapper::toProductEntity);
    }

    public Page<ResponseServiceProduct> findByName(String name, Pageable pageable){
        return repository.findByName(name,pageable)
                .map(ProductEntityResponseMapper::toProductEntity);
    }

    public void deleteProdById(List<String> usItemId) {
        repository.deleteAllById(usItemId);
    }
}
