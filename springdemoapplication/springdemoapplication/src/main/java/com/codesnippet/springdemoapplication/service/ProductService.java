package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private final EmployeeRepository employeeRepository;
   @Autowired
    public ProductService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        System.out.println("productservice is created");


    }
    @PostConstruct
    public void init(){
        System.out.println("postcontruct is created");

    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy");

    }
}
