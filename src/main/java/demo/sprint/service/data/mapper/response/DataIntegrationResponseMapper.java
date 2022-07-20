package demo.sprint.service.data.mapper.response;

import demo.sprint.service.data.model.response.DataServiceResponse;
import demo.sprint.service.data.model.response.ResponseServiceProduct;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataIntegrationResponseMapper {

    public static DataServiceResponse dtServiceResponse(ResponseServiceProduct prodResponse){
        return DataServiceResponse.builder()
                .data((ResponseServiceProduct.builder()
                        .usItemId(prodResponse.usItemId)
                        .id(prodResponse.getId())
                        .segment(prodResponse.getSegment())
                        .type(prodResponse.getType())
                        .name(prodResponse.getName())
                        .build()))
                .build();
                }
}
