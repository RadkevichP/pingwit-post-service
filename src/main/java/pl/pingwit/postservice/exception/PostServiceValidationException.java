package pl.pingwit.postservice.exception;

import java.util.List;

public class PostServiceValidationException extends RuntimeException{

    private final List<String> violations;

    public PostServiceValidationException(String message, List<String> violations) {
        super(message);
        this.violations = violations;
    }
}
