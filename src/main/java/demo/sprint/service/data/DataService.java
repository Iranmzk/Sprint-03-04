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
    /**
     * If the product exists, return it, otherwise throw an exception.
     *
     * @param id The id of the product you want to find.
     * @return Optional<ProductEntity>
     */
    public Optional<ProductEntity> findByUsItemId(String id) {
        return Optional.of(repository.findById(id))
                .orElseThrow(() -> new ApiNotFoundException(id));
    }

    /**
     * It calls the integration service, maps the response to a new object, saves it to the database, and then maps it to
     * another object.
     *
     * @param usItemId The ID of the product you want to find.
     * @return ResponseServiceProduct
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