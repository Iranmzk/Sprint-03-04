package demo.sprint.service.product.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceResponse {
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}
