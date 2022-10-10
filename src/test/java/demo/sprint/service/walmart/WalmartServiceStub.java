package demo.sprint.service.walmart;

import demo.sprint.integration.walmart.model.*;
import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;

import java.util.Optional;

public class WalmartServiceStub {
    static DataIntegrationResponse WalmartIntegrationStubResponse() {
        return DataIntegrationResponse.builder()
                .data(ResponseData.builder()
                        .product(ResponseProduct.builder()
                                .usItemId("54457638")
                                .id("528477X1YAO4")
                                .segment("Gift Cards & Gift Certificates")
                                .type("Gift Cards & Certificates")
                                .name("Birthday Walmart Gift Card")
                                .description("Convenient for you and fun for them," +
                                        " the Walmart Gift Card makes a great gift for anyone.")
                                .priceInfo(ResponsePriceInfo.builder()
                                        .currentPrice(ResponseCurrentPrice.builder()
                                                .price(2.00)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();
    }

    static DataIntegrationResponse WalmartServiceStubBadRequest() {
        return DataIntegrationResponse.builder()
                .data(ResponseData.builder()
                        .product(ResponseProduct.builder()
                                .usItemId(null)
                                .id(null)
                                .segment(null)
                                .type(null)
                                .name(null)
                                .description(null)
                                .priceInfo(ResponsePriceInfo.builder()
                                        .currentPrice(ResponseCurrentPrice.builder()
                                                .price(null)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();
    }

    static ProductEntity productEntityStub() {
        return ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .price(2.00)
                .build();
    }

    static Optional<ProductEntity> WalmartServiceStubExpected() {
        return Optional.ofNullable(ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .price(2.00)
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build());
    }

    static Optional<ProductEntity> WalmartServiceStubResponse() {
        return Optional.ofNullable(ProductEntity.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .price(2.00)
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build());
    }

    static ResponseServiceProduct WalmartServiceResponseExpectedStub() {
        return ResponseServiceProduct.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .price(2.00)
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build();
    }
}
