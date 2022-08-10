package demo.sprint.service.walmart.mapper.response;

import demo.sprint.integration.model.DataIntegrationResponse;
import demo.sprint.model.walmartentity.ProductEntity;


public class DataServiceResponseMapper {

    public static ProductEntity toIntResponse(DataIntegrationResponse response) {
        var product = response.getData().getProduct();
        return ProductEntity.builder()
                .usItemId(product.getUsItemId())
                .id(product.getId())
                .segment(product.getSegment())
                .type(product.getType())
                .name(product.getName())
                .build();
    }
}

