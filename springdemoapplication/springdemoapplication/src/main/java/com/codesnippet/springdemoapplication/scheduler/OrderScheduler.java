package com.codesnippet.springdemoapplication.scheduler;

import com.codesnippet.springdemoapplication.entity.Book;
import com.codesnippet.springdemoapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderScheduler {
    @Autowired
    BookRepository bookRepository;

    @Scheduled(cron = "* * * * * *")
    public void  processPending(){
        System.out.println(new Date());

    }
}
