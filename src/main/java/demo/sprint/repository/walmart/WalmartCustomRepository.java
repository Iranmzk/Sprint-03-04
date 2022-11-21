package demo.sprint.repository.walmart;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WalmartCustomRepository {
    List<ProductEntity> findCustom(ProductQuery productQuery);
}
