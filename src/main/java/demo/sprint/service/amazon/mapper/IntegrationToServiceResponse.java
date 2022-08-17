package demo.sprint.service.amazon.mapper;

import demo.sprint.integration.amazon.model.DocsResponse;
import demo.sprint.service.amazon.model.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegrationToServiceResponse {
    public static List<ProductService> toServiceMapper(DocsResponse response) {
        var product = response.getProductsAmazon();

        return Arrays.stream(product)
                .map(integration -> ProductService.builder()
                .usItemId(integration.getUsItemId())
                .name(integration.getName())
                .price(integration.getPrice())
                .build()).collect(Collectors.toList());
    }
}
