package demo.sprint.integration.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductIntegrationResponse {
   @Id
   public String usItemId;
   public String id;
   public String segment;
   public String type;
   public String name;
}

