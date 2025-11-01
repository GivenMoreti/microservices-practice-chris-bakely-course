package com.example.patient_service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptions {


    private static final Logger log = LoggerFactory.getLogger(GlobalExceptions.class);
    
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex){
        
        log.warn("Email already exists {}",ex.getMessage());

        Map<String,String> errors = new HashMap<>();
        errors.put("message","Email already exists" );

        return ResponseEntity.badRequest().body(errors);
    }
}
