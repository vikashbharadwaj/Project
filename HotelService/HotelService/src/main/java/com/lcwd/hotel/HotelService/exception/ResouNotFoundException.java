package com.lcwd.hotel.HotelService.exception;

public class ResouNotFoundException extends RuntimeException {



    public ResouNotFoundException(String s) {
        super(s);
    }
    public ResouNotFoundException() {
        super("Resource not found");
}}
