package demo.sprint.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus (BAD_REQUEST)
    @ExceptionHandler(ApiRequestException.class)
     ErrorResponse handleApiRequestException(ApiRequestException e) {
          var teste = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(BAD_REQUEST.name())
                        .field(e.getMessage())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build();
            return teste;
    }
}

//
//        ErrorResponse apiException = new ErrorResponse();
//        HttpStatus badRequest = BAD_REQUEST;
//        apiException.setMessage(e.getMessage());
//        apiException.setHttpStatus(badRequest);
//        apiException.setZonedDateTime(ZonedDateTime.now());
////        2. Return response entity
//        return new ResponseEntity<>(e, badRequest);
////        1. Create a payload containing exception details
