package demo.sprint.model.walmartentity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    @NotNull
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}
