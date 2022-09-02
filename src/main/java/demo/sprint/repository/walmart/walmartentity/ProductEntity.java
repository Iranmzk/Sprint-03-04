package demo.sprint.repository.walmart.walmartentity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Walmart")
public class ProductEntity {
    @Id
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
    @JsonProperty("shortDescription")
    public String description;
    public String priceInfo;
}
