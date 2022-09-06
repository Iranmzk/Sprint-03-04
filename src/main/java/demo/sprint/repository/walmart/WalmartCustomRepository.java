package demo.sprint.repository.walmart;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;

import java.util.List;

public interface WalmartCustomRepository {
    List<ProductEntity> find(String usItemId, String name, String segment, String type);
    List<ProductEntity> orderGtePrice(Double price);
}
