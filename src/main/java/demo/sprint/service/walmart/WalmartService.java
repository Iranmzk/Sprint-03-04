package demo.sprint.service.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.model.DataIntegrationResponse;
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


    /**
     * It calls the integration service, maps the response to a new object, saves it to the database, and then maps it to
     * another object.
     *
     * @param usItemId The ID of the product you want to find.
     * @return ResponseServiceProduct
     */
// TODO: VER PQ ESTA RETORNANDO NULLPOINTER, QUANDO USITEMID ESTA VAZIO, RETORNA .ORELSETHROW() - (OK)
    public ResponseServiceProduct findProductIntegration(String usItemId) {
        return Optional.ofNullable(integration.findProductDetails(usItemId))
                .map(productValidation())
                .map(DataServiceResponseMapper::toIntResponse)
                .map(repository::save)
                .map(ProductEntityResponseMapper::toProductEntity)
                .orElseThrow(() -> new ApiNotFoundException("Please,insert a valid usItemId"));
    }


    /**
     * It validates if the product is not null.
     *
     * @return A function that takes a DataIntegrationResponse and returns a DataIntegrationResponse.
     */
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


    /**
     * > It takes a list of ProductEntity objects, maps them to ResponseServiceProduct objects, and returns a list of
     * ResponseServiceProduct objects
     *
     * @return A list of ResponseServiceProduct
     */
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