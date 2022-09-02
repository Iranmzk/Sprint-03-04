package demo.sprint.repository.walmart;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalmartRepository extends MongoRepository<ProductEntity,String>, WalmartCustomRepository {
//    @Query(fields = "{name :1, type: 1,segment: 1}")
    List<ProductEntity> findByNameContains(String name);
}
