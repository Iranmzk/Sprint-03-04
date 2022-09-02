package demo.sprint.service.amazon.mapper;

import demo.sprint.repository.amazon.AmazonEntity;
import demo.sprint.service.amazon.model.ProductService;
//NOT IN USE
public class EntityToServiceResponse {
    public static ProductService toServiceResponse(AmazonEntity product){
        return ProductService.builder()
                .usItemId(product.getUsItemId())
                .name(product.getName())
                .price(product.getPrice())
                .rate(product.getRate())
                .prime(product.getPrime())
                .build();
    }
}
