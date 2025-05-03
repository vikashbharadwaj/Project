package com.security.SpringSecurity.controller;

import com.security.SpringSecurity.model.Userss;
import com.security.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping("/register")
    public Userss register(@RequestBody Userss userss){
        return userService.register(userss);

    }
}
