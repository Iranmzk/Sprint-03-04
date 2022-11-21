package demo.sprint.repository.walmart.walmartentity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuery {

    // Setting a default value for the field.
    @Builder.Default
    @ApiModelProperty(
            value = "Passed Empty when the name is not being queried",
    example = "PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense Controller W/ Pulse Headset Limited Bundle")
    private String name = "";

    // A Lombok annotation that allows you to set a default value for a field.
    @Builder.Default
    @ApiModelProperty(position = 1,
    value = "Omit this attribute when price floor is not being queried",
    example = "799.99")
    private Double priceMin = 0.00;

    // Setting a default value for the field.
    @Builder.Default
    @ApiModelProperty(position = 2,
    value = "Omit this attribute when price max is not being queried",
    example = "799.99")
    private Double priceMax = 9999.99;
}
