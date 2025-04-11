package com.udemy.Udemyjpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
@Configuration
@Aspect
public class AspectConfig {

    Logger logger =LoggerFactory.getLogger(getClass());

//    @Before(value = "execuation(*com.udemy.Udemyjpa.controller.*.*(..)")
//    public void getAdvice(JoinPoint joinPoint){
//        logger.info("inside before advice");
//    }
//    @Before(value = "execuation(*com.udemy.Udemyjpa.controller.*.*(..)and args(object)")
//    public void getAdvice(JoinPoint joinPoint,Object object){
//        logger.info("Request"+object);
//    }
//    @After(value = "execuation(*com.udemy.Udemyjpa.controller.*.*(..)and args(object)")
//    public void getAdvice(JoinPoint joinPoint,Object object){
//        logger.info("Request"+object);
//    }
//    @AfterReturning(value = "execuation(*com.udemy.Udemyjpa.controller.*.*(..)and args(object)",
//    returning = "returningObject")
//    public void getAdvice(JoinPoint joinPoint,Object object,Object returningObject){
//        logger.info("Response"+returningObject);
//    }
    @Around(value = "execuation(*com.udemy.Udemyjpa.controller.*.*(..)and args(object)")
    public void getAdvice(ProceedingJoinPoint proceedingJoinPoint, Object object) throws Throwable {
        logger.info("Request"+object);

        Object returning=null;

       returning= proceedingJoinPoint.proceed();
    }


}