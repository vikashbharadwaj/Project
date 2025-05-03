package com.bitsnbytes.productlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handleAlreadyExitException(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

    }
}
