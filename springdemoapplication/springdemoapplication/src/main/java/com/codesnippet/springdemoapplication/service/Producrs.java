package com.codesnippet.springdemoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producrs {
    @Autowired
    Payments payments;

    public Producrs() {
        System.out.println("products");
    }
}
