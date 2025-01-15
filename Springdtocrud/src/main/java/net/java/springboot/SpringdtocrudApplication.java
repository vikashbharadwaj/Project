package net.java.springboot;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdtocrudApplication {
	
	@Bean
	public ModelMapper mapper() {
		ModelMapper mapper=new ModelMapper();
		return mapper;
		
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringdtocrudApplication.class, args);
		
		
	}

}
