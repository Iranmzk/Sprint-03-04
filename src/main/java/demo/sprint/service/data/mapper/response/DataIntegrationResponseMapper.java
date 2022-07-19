package demo.sprint.service.data.mapper.response;

import demo.sprint.integration.data.DataIntegrationResponse;
import demo.sprint.integration.product.ProductIntegrationResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataIntegrationResponseMapper {

    public static DataIntegrationResponse dtServiceResponse(ProductIntegrationResponse prodResponse){
        return DataIntegrationResponse.builder()
                .data((ProductIntegrationResponse.builder()
                        .usItemId(prodResponse.usItemId)
                        .id(prodResponse.getId())
                        .segment(prodResponse.getSegment())
                        .type(prodResponse.getType())
                        .name(prodResponse.getName())
                        .build()))
                .build();
                }
}
