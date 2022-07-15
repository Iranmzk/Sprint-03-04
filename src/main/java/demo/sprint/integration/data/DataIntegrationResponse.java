package demo.sprint.integration.data;

import demo.sprint.integration.product.ProductIntegrationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataIntegrationResponse {
    public List<ProductIntegrationResponse> product = new ArrayList<>();
//    public ProductIntegrationResponse product;
}

