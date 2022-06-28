package demo.sprint.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private ZonedDateTime zonedDateTime;
}


