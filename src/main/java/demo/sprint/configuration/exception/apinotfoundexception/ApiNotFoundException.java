package demo.sprint.configuration.exception.apinotfoundexception;
public class ApiNotFoundException extends RuntimeException{
    public ApiNotFoundException(String message) {
        super(message);
    }
}
