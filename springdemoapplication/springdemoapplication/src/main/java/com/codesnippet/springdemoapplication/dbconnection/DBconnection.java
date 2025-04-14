package com.codesnippet.springdemoapplication.dbconnection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
public class DBconnection {
    @Autowired
    MySqlConnection mySqlConnection;
    @Autowired
    NoSqlConnection noSqlConnection;
    @Value("${userName}")
    String userName;
    @Value("${password}")
    String Password;

    @PostConstruct
    public void init(){
        System.out.println("db connection int");
        System.out.println("mysqlconnection"+mySqlConnection);
        System.out.println("nosqlconnection"+noSqlConnection);

        System.out.println("userName"+userName+"password"+Password);

    }
}
