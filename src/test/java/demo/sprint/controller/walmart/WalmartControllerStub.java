package demo.sprint.controller.walmart;

import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;

public class WalmartControllerStub {

    static ProductControllerResponse WalmartControllerStubResponse(){
        return  ProductControllerResponse.builder()
                .usItemId("54457638")
                .id("528477X1YAO4")
                .segment("Gift Cards & Gift Certificates")
                .type("Gift Cards & Certificates")
                .name("Birthday Walmart Gift Card")
                .description("Convenient for you and fun for them," +
                        " the Walmart Gift Card makes a great gift for anyone.")
                .build();
    }

    static ProductControllerResponse WalmartControllerExpectedStub(){
        return ProductControllerResponse.builder()
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
