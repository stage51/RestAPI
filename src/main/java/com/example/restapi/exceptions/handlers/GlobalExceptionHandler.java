package com.example.restapi.exceptions.handlers;

import com.example.restapi.exceptions.IllegalInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalInputException.class)
    public ResponseEntity<?> handleInputException(IllegalInputException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}