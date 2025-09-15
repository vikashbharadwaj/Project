package com.lcwd.user.service.UserService.exception;

import com.lcwd.user.service.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse>handleResource(UserNotFoundException e){
        String message = e.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).sucess(true).httpStatus(HttpStatus.NOT_FOUND).build();
         return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
