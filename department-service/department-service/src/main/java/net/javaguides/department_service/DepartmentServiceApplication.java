package net.javaguides.department_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Department service Rest Api",
				description = "Department service",
				version = "v.01",
				contact =@Contact(
						name = "vikash",
						email = "vikas@gmail.com"
						),
				license = @License(
						name = "Apache 2.0"
				)
						),
		externalDocs = @ExternalDocumentation(
				description = "Department-service"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
