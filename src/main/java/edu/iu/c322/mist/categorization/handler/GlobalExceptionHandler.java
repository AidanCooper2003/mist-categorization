package edu.iu.c322.mist.categorization.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exception){
        String errorMessages = exception.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
                .collect(java.util.stream.Collectors.joining(", "));
        return ResponseEntity.badRequest().body(errorMessages);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleException(ConstraintViolationException exception){
        String errorMessages = exception.getConstraintViolations().stream().map(error -> error.getMessage())
                .collect(java.util.stream.Collectors.joining(", "));
        return ResponseEntity.badRequest().body(errorMessages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleException(ResponseStatusException exception){
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());
    }


}