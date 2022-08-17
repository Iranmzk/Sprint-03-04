package demo.sprint.repository;

import demo.sprint.model.amazon.AmazonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//NOT IN USE
@Repository
public interface AmazonRepository extends MongoRepository<AmazonEntity,String> {
//    List<AmazonEntity> findByNomeAmazonProducts(String name);
}
