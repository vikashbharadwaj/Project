package com.lcwd.user.service.UserService.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String s) {
        super("user not found on server");
    }
}
