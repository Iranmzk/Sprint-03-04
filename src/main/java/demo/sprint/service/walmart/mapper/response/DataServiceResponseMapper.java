package demo.sprint.service.walmart.mapper.response;

import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import demo.sprint.repository.walmart.walmartentity.ProductEntity;


public class DataServiceResponseMapper {

    public static ProductEntity toIntResponse(DataIntegrationResponse response) {
        var product = response.getData().getProduct();
        var price = response.getData().getProduct().getPriceInfo().getCurrentPrice();

        return ProductEntity.builder()
                .usItemId(product.getUsItemId())
                .id(product.getId())
                .segment(product.getSegment())
                .type(product.getType())
                .name(product.getName())
                .description(product.getDescription())
                .price(price.getPrice())
                .currencyUnit(price.getCurrencyUnit())
                .build();
    }
}

