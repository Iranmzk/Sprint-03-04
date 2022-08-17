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
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
    @JsonProperty("shortDescription")
    public String description;
}
