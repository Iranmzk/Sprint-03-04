package demo.sprint.repository;

import demo.sprint.repository.model.walmartentity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalmartRepository extends MongoRepository<ProductEntity,String> {
    Page<ProductEntity> findByNameContains(String name, Pageable pageable);
}
