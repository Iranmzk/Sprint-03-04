package demo.sprint.configuration.exception;
public class ApiNotFoundException extends RuntimeException{
    public ApiNotFoundException(String message) {
        super(message);
    }
}
