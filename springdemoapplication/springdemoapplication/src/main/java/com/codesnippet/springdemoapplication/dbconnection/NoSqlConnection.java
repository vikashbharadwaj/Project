package com.codesnippet.springdemoapplication.dbconnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
public class NoSqlConnection {

    public NoSqlConnection() {
        System.out.println("nosqlconnection init");
    }
}
