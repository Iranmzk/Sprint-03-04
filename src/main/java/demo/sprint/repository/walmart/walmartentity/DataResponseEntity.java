package demo.sprint.repository.walmart.walmartentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponseEntity {
    private ProductEntity product;
}
