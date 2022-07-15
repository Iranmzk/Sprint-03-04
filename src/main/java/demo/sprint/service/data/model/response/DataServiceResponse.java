package demo.sprint.service.data.model.response;

import demo.sprint.integration.product.ProductIntegrationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataServiceResponse {
    public List<ProductIntegrationResponse> product = new ArrayList<>();
}
