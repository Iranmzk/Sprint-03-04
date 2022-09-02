package demo.sprint.repository.walmart.stub;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;

import java.util.List;
import java.util.Optional;

public class WalmartRepositoryStub {

    public static Optional<ProductEntity> expectedRequiredStub(){
        return Optional.ofNullable(ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build());
    }
    public static List<ProductEntity> expectedResponseFindByNameStub(){
        return List.of(ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build());
    }
    public static ProductEntity expectedEntityStub(){
        return ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build();
    }
}
