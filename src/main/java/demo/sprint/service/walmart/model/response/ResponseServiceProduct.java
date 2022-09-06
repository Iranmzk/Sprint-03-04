package demo.sprint.service.walmart.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseServiceProduct {
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
