package com.fintech.user_auth_service.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleDatabaseErrors(SQLIntegrityConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("Error: Bhai yeh email ya data pehle se use ho raha hai!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllOtherErrors(Exception ex) {
        // Yeh sabse aakhiri jaal hai. Agar upar ke dono trap miss ho gaye, toh yeh pakad lega.
        return ResponseEntity.status(500).body("Server mein kuch gadbad hai: " + ex.getMessage());
    }
}
