package pl.pingwit.postservice.exception;

public class PostServiceNotFoundException extends RuntimeException {

    public PostServiceNotFoundException(String message) {
        super(message);
    }
}
