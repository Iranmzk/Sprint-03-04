package demo.sprint.integration.data;

import demo.sprint.integration.product.ProductIntegrationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataIntegrationResponse {
    public ProductIntegrationResponse data;
}

