package demo.sprint.service.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.walmart.WalmartIntegration;
import demo.sprint.repository.walmart.WalmartRepository;
import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.service.walmart.mapper.response.DataServiceResponseMapper;
import demo.sprint.service.walmart.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static demo.sprint.configuration.exception.apiexterror.ApiErrorHandler.productValidation;

@Service
@AllArgsConstructor
public class WalmartService {

    private WalmartIntegration integration;
    private WalmartRepository repository;

    public Optional<ProductEntity> findByUsItemId(String usItemId) {
        return repository.findById(usItemId);
    }

    public List<ProductEntity> findByNameEntity(String name) {
        return repository.findByNameContains(name);
    }

    public ResponseServiceProduct findProductIntegration(String usItemId) {
        return Optional.ofNullable(integration.findProductDetails(usItemId))
                .map(productValidation())
                .map(DataServiceResponseMapper::toIntResponse)
                .map(repository::save)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseThrow(() -> new ApiNotFoundException("not found"));
    }

    public Page<ResponseServiceProduct> findAllProd(Pageable pageable) {
        return repository.findAll(pageable)
                .map(ProductEntityResponseMapper::toProductEntity);
    }

    public void deleteProdById(List<String> usItemId) {
        repository.deleteAllById(usItemId);
    }

    public List<ResponseServiceProduct> find(String usItemId, String name, String segment, String type) {
        return repository.find(usItemId, name, segment, type)
                .stream()
                .map(ProductEntityResponseMapper::toProductEntity)
                .collect(Collectors.toList());
    }

    public List<ResponseServiceProduct> orderByPriceGte(Double price) {
        return repository.orderGtePrice(price)
                .stream()
                .map(ProductEntityResponseMapper::toProductEntity)
                .collect(Collectors.toList());
    }
}
