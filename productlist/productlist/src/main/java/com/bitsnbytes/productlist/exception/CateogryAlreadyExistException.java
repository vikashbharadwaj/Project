package com.bitsnbytes.productlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CateogryAlreadyExistException extends RuntimeException{

    public CateogryAlreadyExistException(String message) {
        super(message);
    }
}
