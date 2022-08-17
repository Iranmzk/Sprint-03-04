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
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
    @JsonProperty("shortDescription")
    public String description;
}
