package demo.sprint.repository.walmart.walmartentity;

import demo.sprint.repository.walmart.WalmartCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class WalmartCustomRepositoryImpl implements WalmartCustomRepository {
    final MongoTemplate template;

    @Override
    public List<ProductEntity> find(String usItemId,
                                    String name,
                                    String segment,
                                    String type) {

        final Query query = new Query();
        query.fields().include("usItemId").include("name").include("segment").include("price");
        final List<Criteria> criteria = new ArrayList<>();

        if (usItemId != null && !usItemId.isEmpty())
            criteria.add(Criteria.where("usItemId").is(usItemId));
        if (name != null && !name.isEmpty())
            criteria.add(Criteria.where("name").regex(name));
        if (segment != null && !segment.isEmpty())
            criteria.add(Criteria.where("segment").regex(segment));
        if (type != null && !type.isEmpty())
            criteria.add(Criteria.where("type").regex(type));

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));

        return template.find(query, ProductEntity.class);
    }

    @Override
    public List<ProductEntity> orderGtePrice(Double price) {
        final Query query = new Query();

        List<Criteria> criteria = new ArrayList<>();
        if (price != null)
            criteria.add(Criteria.where("price").lte(price));

        if (criteria.isEmpty())
            query.addCriteria(new Criteria()
                    .andOperator(criteria
                            .toArray(new Criteria[0])));

        return template.find(query, ProductEntity.class);
    }
}
