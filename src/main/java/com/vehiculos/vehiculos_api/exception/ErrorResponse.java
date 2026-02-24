package com.vehiculos.vehiculos_api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse(int status, LocalDateTime timestamp, String message,
                         Map<String, String> errors) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
