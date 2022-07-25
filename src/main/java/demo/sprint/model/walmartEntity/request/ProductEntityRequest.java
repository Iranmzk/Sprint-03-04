package demo.sprint.model.walmartEntity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntityRequest {
    public String usItemId;
    public String name;
}
