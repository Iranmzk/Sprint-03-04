package demo.sprint.controller.walmart.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductControllerResponse {
    @NotNull
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
