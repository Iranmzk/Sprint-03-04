package demo.sprint.controller.product.model.mapper;

import demo.sprint.controller.product.model.response.ProductControllerResponse;
import demo.sprint.service.data.model.response.ResponseServiceProduct;

public class ProductControllerResponseMapper {
    public static ProductControllerResponse toControllerResponse(ResponseServiceProduct response){
        return ProductControllerResponse.builder()
                .usItemId(response.getUsItemId())
                .id(response.getId())
                .type(response.getType())
                .segment(response.getSegment())
                .name(response.getName())
                .build();
    }
}
