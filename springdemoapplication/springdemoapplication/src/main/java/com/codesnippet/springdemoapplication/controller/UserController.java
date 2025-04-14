package com.codesnippet.springdemoapplication.controller;

import com.codesnippet.springdemoapplication.entity.User;
import com.codesnippet.springdemoapplication.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private User user;

    public UserController() {
        System.out.println("user controller init");
    }

    @PostConstruct
    public void init() {
        System.out.println("usercontroller hashcode " + this.hashCode()+"user hashcode");

    }
