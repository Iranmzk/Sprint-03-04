package demo.sprint.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiExceptionBadRequest> handleApiRequestException (ApiRequestException e, HttpServletRequest httpServletRequest){
        //1. Create a payload containing exception details
        HttpStatus badRequest = BAD_REQUEST;
//        ApiExceptionBadRequest apiException = new ApiExceptionBadRequest(
//                e.getMessage(),
//                e,
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
        ApiExceptionBadRequest apiException = new ApiExceptionBadRequest();
        apiException.setMessage(e.getMessage());
//        apiException.setError("Não encontrado");
        apiException.setHttpStatus(badRequest);
        apiException.setZonedDateTime(ZonedDateTime.now());
        //2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
