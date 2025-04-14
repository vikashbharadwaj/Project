package com.codesnippet.springdemoapplication.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Checkoutservice {

    private final Payments payments;

    @Autowired
    public Checkoutservice(Payments payments) {  // Fix constructor syntax and inject dependency
        this.payments = payments;
    }

    @PostConstruct
    public void init() {
        System.out.println("Checkoutservice initiated");
    }

    public void checkoutOrder(double amount) {
        payments.processPayment(amount);
        System.out.println("Checkout order for amount: " + amount);
    }
}
