package demo.sprint.controller.product.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductControllerResponse {
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}
