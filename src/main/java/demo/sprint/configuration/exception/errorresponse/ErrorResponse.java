package demo.sprint.configuration.exception.errorresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import demo.sprint.configuration.exception.errorobject.ErrorObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    private List<ErrorObject> error;
}


