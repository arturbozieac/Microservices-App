package app.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("app")
public class Microservices {

	public static void main(String[] args) {
		SpringApplication.run(Microservices.class, args);
	}
	
}
