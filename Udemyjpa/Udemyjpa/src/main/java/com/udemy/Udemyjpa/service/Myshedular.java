package com.udemy.Udemyjpa.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Myshedular {

    @Scheduled(cron = "*/10 * * * * *")
    public void firstSchedular(){
        System.out.println(new Date());

    }
}
