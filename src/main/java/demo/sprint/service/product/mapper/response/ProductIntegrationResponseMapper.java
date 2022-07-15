package demo.sprint.service.product.mapper.response;

import demo.sprint.integration.product.ProductIntegrationResponse;
import demo.sprint.service.product.model.response.ProductServiceResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductIntegrationResponseMapper {
    public static ProductServiceResponse prodServiceResponse (ProductIntegrationResponse response){
        return ProductServiceResponse.builder()
                .usItemId(response.getUsItemId())
                .id(response.getId())
                .segment(response.getSegment())
                .type(response.getType())
                .name(response.getName())
                .build();

    }
}
