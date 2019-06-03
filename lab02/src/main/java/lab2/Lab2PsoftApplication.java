package lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"lab2.controller", "lab2.service", "lab2.dao", "lab2.exception", "lab2.model"})
public class Lab2PsoftApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Lab2PsoftApplication.class, args);
	}

}
