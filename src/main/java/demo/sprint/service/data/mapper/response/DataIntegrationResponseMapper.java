package demo.sprint.service.data.mapper.response;

import demo.sprint.integration.data.DataIntegrationResponse;
import demo.sprint.integration.product.ProductIntegrationResponse;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class DataIntegrationResponseMapper {

    public static DataIntegrationResponse dtServiceResponse(DataIntegrationResponse datResponse, ProductIntegrationResponse prodResponse){
        return DataIntegrationResponse.builder()
                .product(List.of(ProductIntegrationResponse.builder()
                .usItemId(prodResponse.getUsItemId())
                .id(prodResponse.getId())
                .segment(prodResponse.getSegment())
                .type(prodResponse.getType())
                .name(prodResponse.getName())
                .build()))
                .build();
                }
}
