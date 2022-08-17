package demo.sprint.controller.walmart.facade;

import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import demo.sprint.service.walmart.model.response.ResponseServiceProduct;

public class ControllerFacadeStub {

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

    static ResponseServiceProduct WalmartControllerExpectedStub(){
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
