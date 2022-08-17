package demo.sprint.controller.amazon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControllerResponse {
    private String usItemId;
    private String name;
    private String price;
}
