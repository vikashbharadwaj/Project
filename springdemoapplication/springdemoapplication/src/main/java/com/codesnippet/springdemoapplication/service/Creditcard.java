package com.codesnippet.springdemoapplication.service;

import org.springframework.stereotype.Service;

@Service
public class Creditcard implements Payments {

    @Override
    public void processPayment(double amount) {
        System.out.println("credit card processing");

    }
}
