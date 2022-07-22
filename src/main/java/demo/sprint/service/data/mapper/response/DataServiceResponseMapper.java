package demo.sprint.service.data.mapper.response;

import demo.sprint.integration.data.model.DataIntegrationResponse;
import demo.sprint.model.walmartEntity.ProductEntity;


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

