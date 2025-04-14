package com.codesnippet.springdemoapplication.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(*com.codesnippet.springdemoapplication.service.EmployeeService.getEmployee(..))")
    public void log(){
        System.out.println("aspect log");
    }

}
