package demo.sprint.repository.walmart.walmartentity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// Suppressing all warnings.
@SuppressWarnings("ALL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuery {
    @Builder.Default
    @ApiModelProperty(position = 0,
    value = "Passed Empty when the name is not being queried",
    example = "PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense Controller W/ Pulse Headset Limited Bundle")
    private String name = "";

    @Builder.Default
    @ApiModelProperty(position = 1,
    value = "Omit this attribute when price floor is not being queried",
    example = "799.99")
    private Double priceFloor = 0.00;

    @Builder.Default
    @ApiModelProperty(position = 2,
    value = "Omit this attribute when price max is not being queried",
    example = "799.99")
    private Double priceMax = 999999.99;


}
