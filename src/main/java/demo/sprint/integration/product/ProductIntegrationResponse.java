package demo.sprint.integration.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductIntegrationResponse {
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}

