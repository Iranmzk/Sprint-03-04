package demo.sprint.configuration.exception;


import demo.sprint.configuration.exception.errorobject.ErrorObject;
import demo.sprint.configuration.exception.errorresponse.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiNotFoundException.class)
    @ResponseStatus (NOT_FOUND)
    public ErrorResponse handleApiRequestException(ApiNotFoundException e) {
        return  ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(NOT_FOUND.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus (INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(INTERNAL_SERVER_ERROR.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus (METHOD_NOT_ALLOWED)
    public ErrorResponse methodArgumentNotValidException(Exception e) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(List.of(ErrorObject.builder()
                        .message(e.getMessage())
                        .field(METHOD_NOT_ALLOWED.name())
                        .parameter(e.getClass().getSimpleName())
                        .build()))
                .build();
    }

}
