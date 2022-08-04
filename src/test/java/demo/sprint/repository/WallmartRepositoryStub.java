package demo.sprint.repository;

import demo.sprint.integration.data.model.DataIntegrationResponse;
import demo.sprint.integration.data.model.ResponseData;
import demo.sprint.integration.data.model.ResponseProduct;

public class WallmartRepositoryStub {

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
                                .build())
                        .build())
                .build();
    }
}
