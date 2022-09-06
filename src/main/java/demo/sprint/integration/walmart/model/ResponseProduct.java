package demo.sprint.integration.walmart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseProduct {
    @NotNull
    private String usItemId;
    private String id;
    private String segment;
    private String type;
    private String name;
    @JsonProperty("shortDescription")
    private String description;
    private ResponsePriceInfo priceInfo;
}
