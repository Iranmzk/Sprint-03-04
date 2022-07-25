package demo.sprint.service.data.mapper.response;

import demo.sprint.model.walmartEntity.ProductEntity;
import demo.sprint.service.data.model.response.ResponseServiceProduct;


public class ProductEntityResponseMapper {

    public static ResponseServiceProduct toProductEntity(ProductEntity entity){
        return ResponseServiceProduct.builder()
                .usItemId(entity.getUsItemId())
                .id(entity.getId())
                .segment(entity.getSegment())
                .type(entity.getType())
                .name(entity.getName())
                .build();
    }

//    public static ResponseServiceProduct getIntegration(DataIntegrationResponse response){
//        var responseProdIntegration = response.getData().getProduct();
//        return ResponseServiceProduct.builder()
//                .usItemId(responseProdIntegration.getUsItemId())
//                .id(responseProdIntegration.getId())
//                .segment(responseProdIntegration.getSegment())
//                .type(responseProdIntegration.getType())
//                .name(responseProdIntegration.getName())
//                .build();
//    }
}
