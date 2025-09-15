package com.lcwd.hotel.HotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResouNotFoundException.class)
    public ResponseEntity<Map<String,Object>>notFoundHandler(ResouNotFoundException ex){
        Map map=new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("sucess",false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }
}
