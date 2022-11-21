package demo.sprint.repository.walmart.walmartentity;

import demo.sprint.repository.walmart.WalmartCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class WalmartCustomRepositoryImpl implements WalmartCustomRepository {
    final MongoTemplate template;

    @Override
    public List<ProductEntity> findCustom(ProductQuery productQuery) {

        final Query query = new Query();
        query.fields().include("usItemId").include("name").include("price");
        query.addCriteria(
                Criteria.where("name").regex(StringUtils.capitalize(productQuery.getName()))
                        .and("price").gte(productQuery.getPriceMin()).lte(productQuery.getPriceMax()));
        return template.find(query, ProductEntity.class);
    }

}

