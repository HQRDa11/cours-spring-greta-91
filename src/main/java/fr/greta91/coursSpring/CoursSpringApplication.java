package fr.greta91.coursSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration //convention sur la configuration
//@ComponentScan
public class CoursSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursSpringApplication.class, args);
	}
	
	@Bean
	public String test() {
		return "Hello world !";
	}

}
