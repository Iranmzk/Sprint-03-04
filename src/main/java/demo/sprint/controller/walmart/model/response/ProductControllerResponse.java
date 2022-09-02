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
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
    @JsonProperty("shortDescription")
    public String description;
//    public String priceInfo;
}
