package com.example.phonemanagement.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicateResourceException extends RuntimeException {
    @ResponseStatus(HttpStatus.CONFLICT) // Returns HTTP 409 Conflict
    public class duplicateResourceException extends RuntimeException {

        public duplicateResourceException(String message) {
            super(message);
        }
    }
}
