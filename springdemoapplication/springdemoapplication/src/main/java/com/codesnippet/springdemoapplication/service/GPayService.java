package com.codesnippet.springdemoapplication.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary// Explicitly define bean name
public class GPayService implements  Payments{
    @Override
    public void processPayment(double amount) {
        System.out.println("g pay payment processing");
    }
}
