package demo.sprint.service.data;

import demo.sprint.configuration.exception.ApiNotFoundException;
import demo.sprint.integration.data.WalmartIntegration;
import demo.sprint.model.walmartEntity.ProductEntity;
import demo.sprint.repository.WalmartRepository;
import demo.sprint.service.data.mapper.response.DataServiceResponseMapper;
import demo.sprint.service.data.mapper.response.ProductEntityResponseMapper;
import demo.sprint.service.data.model.response.ResponseServiceProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataService {

    private WalmartIntegration integration;

    private WalmartRepository repository;

    public ProductEntity save(ProductEntity prod) {
        return repository.save(prod);
    }

    /*
    BUSCA APENAS NO BANCO DE DADOS
     */
    public Optional<ProductEntity> findByUsItemId(String id) {
        return Optional.of(repository.findById(id))
                .orElseThrow(() -> new ApiNotFoundException(id));
    }

    /*
    BUSCA APENAS NA INTEGRAÇÃO
    */
    public ResponseServiceProduct findProductIntegration(String usItemId) {
        return Optional.of(integration.findProductDetails(usItemId))
                .map(DataServiceResponseMapper::toIntResponse)
                .map(repository::save)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseThrow(() -> new ApiNotFoundException("ID NÃO ENCONTRADO:" + usItemId));
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