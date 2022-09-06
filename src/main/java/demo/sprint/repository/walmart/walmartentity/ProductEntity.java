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
    private String usItemId;
    private String id;
    private String segment;
    private String type;
    private String name;
    @JsonProperty("shortDescription")
    private String description;
    private Double price;
    private String currencyUnit;
}
