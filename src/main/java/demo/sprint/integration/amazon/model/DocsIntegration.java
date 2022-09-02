package demo.sprint.integration.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocsIntegration {
    @JsonProperty("product_id")
    public String usItemId;
    @JsonProperty("product_title")
    public String name;
    @JsonProperty("app_sale_price")
    public String price;
    @JsonProperty("evaluate_rate")
    public String rate;
    @JsonProperty("isPrime")
    public String prime;

}
