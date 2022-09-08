package demo.sprint.repository.walmart;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;

import java.util.List;

public interface WalmartCustomRepository {
    List<ProductEntity> find(ProductQuery productQuery);
}
