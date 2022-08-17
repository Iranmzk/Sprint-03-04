package demo.sprint.model.amazon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmazonEntity {
    public String usItemId;
    public String name;
    public String price;
}
