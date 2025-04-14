package com.codesnippet.springdemoapplication;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
//@EnableCaching
//@EnableTransactionManagement
public class SpringdemoapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoapplicationApplication.class, args);
	}

}
