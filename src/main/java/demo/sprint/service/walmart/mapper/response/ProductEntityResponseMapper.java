package demo.sprint.service.walmart.mapper.response;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
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
                .price(entity.getPrice())
                .currencyUnit(entity.getCurrencyUnit())
                .build();
    }

}
