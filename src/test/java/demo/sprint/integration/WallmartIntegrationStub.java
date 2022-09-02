package demo.sprint.integration;

import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import demo.sprint.integration.walmart.model.ResponseData;
import demo.sprint.integration.walmart.model.ResponseProduct;

public class WallmartIntegrationStub {

    /**
     * It creates a DataIntegrationResponse object with the following fields:
     * - data
     *     - product
     *         - usItemId
     *         - id
     *         - segment
     *         - type
     *         - name
     *
     * @return A DataIntegrationResponse object.
     */
    static DataIntegrationResponse DataIntegrationResponseExpected(){
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
                                .build())
                        .build())
                .build();
    }

    static DataIntegrationResponse prodIntegrationResponse(){
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
                                .build())
                        .build())
                .build();
    }
}
