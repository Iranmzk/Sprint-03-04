package demo.sprint.repository;

import demo.sprint.model.walmartEntity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalmartRepository extends MongoRepository<ProductEntity,String> {
}
