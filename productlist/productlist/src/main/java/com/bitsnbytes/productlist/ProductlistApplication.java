package com.bitsnbytes.productlist;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@OpenAPIDefinition
		(info=@Info(
						title = "product service rest api",
						description = "product service",
						version = "v1",
						contact = @Contact(
								name = "vikash",
								email = "vikashbharadwaj716@gmail.com"
						)
				),
				externalDocs = @ExternalDocumentation(
						description = "sharepointurl",
						url = "example.com"
				)
		)
//@Slf4j
@SpringBootApplication
public class ProductlistApplication {

	//private static final Logger logger= LoggerFactory.getLogger(ProductlistApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ProductlistApplication.class, args);

		//String str="test";
     //currely bracket ko place holder bolte hai
	//	log.info("product service started sucessfully {}",str);
	}

}