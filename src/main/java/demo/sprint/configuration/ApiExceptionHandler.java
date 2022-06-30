package demo.sprint.configuration;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;


import java.net.BindException;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus (BAD_REQUEST)
     public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException  e) {
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

    @ExceptionHandler(ApiRequestException.class)
    @ResponseStatus (BAD_REQUEST)
    public ErrorResponse handleApiRequestException(ApiRequestException e) {
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

    @ExceptionHandler(Exception.class)
    @ResponseStatus (INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        var teste = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(INTERNAL_SERVER_ERROR.name())
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
