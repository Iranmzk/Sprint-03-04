package demo.sprint.integration.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseProduct {
    public String usItemId;
    public String id;
    public String segment;
    public String type;
    public String name;
}
