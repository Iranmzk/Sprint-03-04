package demo.sprint.service.walmart.facade;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;

import java.util.Optional;

public class WalmartServiceFacadeStub {

    static Optional<ProductEntity> WalmartServiceStubResponse(){
        return  Optional.ofNullable(ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build());
    }

    static ResponseServiceProduct WalmartServiceResponseExpectedStub(){
        return ResponseServiceProduct.builder()
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
