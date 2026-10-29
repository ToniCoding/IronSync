package dev.ironsync.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        LocalDateTime timestamp,
        String error,
        String message,
        Map<String, String> validationErrors
) {
    // Constructor overload for standard errors without field validations
    public ErrorResponse(LocalDateTime timestamp, String error, String message) {
        this(timestamp, error, message, null);
    }
}
