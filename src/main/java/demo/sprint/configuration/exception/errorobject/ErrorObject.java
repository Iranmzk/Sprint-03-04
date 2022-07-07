package demo.sprint.configuration.exception.errorobject;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorObject {
    private String message;
    private String field;
    private String parameter;
}


