package demo.sprint.service.data.model.response;

import demo.sprint.service.product.model.response.ProductServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataServiceResponse {
    public ProductServiceResponse data;
}
