package demo.sprint.service.walmart.mapper.response;

import demo.sprint.model.walmartentity.ProductEntity;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;


public class ProductEntityResponseMapper {

    public static ResponseServiceProduct toProductEntity(ProductEntity entity){
//        var product = entity.getData().getProduct();
        return ResponseServiceProduct.builder()
                .usItemId(entity.getUsItemId())
                .id(entity.getId())
                .segment(entity.getSegment())
                .type(entity.getType())
                .name(entity.getName())
                .description(entity.getDescription())
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
