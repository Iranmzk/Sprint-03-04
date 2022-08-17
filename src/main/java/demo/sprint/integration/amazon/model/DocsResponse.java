package demo.sprint.integration.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocsResponse {
    @JsonProperty("docs")
    public DocsIntegration[] productsAmazon;
}
