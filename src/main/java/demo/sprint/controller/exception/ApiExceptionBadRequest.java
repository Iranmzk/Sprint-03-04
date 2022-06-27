package demo.sprint.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiExceptionBadRequest {
    private String message;
//    private String error;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;
}


