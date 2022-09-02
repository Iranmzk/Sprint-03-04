package demo.sprint.repository.walmart.walmartentity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}
