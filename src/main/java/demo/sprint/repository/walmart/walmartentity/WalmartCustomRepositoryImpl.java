package demo.sprint.repository.walmart.walmartentity;

import demo.sprint.repository.walmart.WalmartCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@AllArgsConstructor
public class WalmartCustomRepositoryImpl implements WalmartCustomRepository {
    final MongoTemplate template;

    @Override
    public List<ProductEntity> find(ProductQuery productQuery) {

        final Query query = new Query();
        //        if (productQuery.getName() != null && !productQuery.getName().isEmpty()) {

        query.addCriteria(Criteria.where("name")
                .regex(StringUtils.capitalize(productQuery.getName()))
                .and("price")
                .gt(productQuery.getPriceFloor())
                .lt(productQuery.getPriceMax()));


        return template.find(query, ProductEntity.class);
    }

}
//        query.fields().include("usItemId").include("name").include("segment").include("price");
//        final List<Criteria> criteria = new ArrayList<>();

//        if (usItemId != null && !usItemId.isEmpty())
//            criteria.add(Criteria.where("usItemId").is(usItemId));
//        if (name != null && !name.isEmpty())
//            criteria.add(Criteria.where("name").regex(name));
//        if (segment != null && !segment.isEmpty())
//            criteria.add(Criteria.where("segment").is(segment));
//        if (type != null && !type.isEmpty())
//            criteria.add(Criteria.where("type").is(type));
//        if (price != null)
//            criteria.add(Criteria.where("price").lte(price).gte(price));
//
//        if (!criteria.isEmpty())
//            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
//
//        return template.find(query, ProductEntity.class);

