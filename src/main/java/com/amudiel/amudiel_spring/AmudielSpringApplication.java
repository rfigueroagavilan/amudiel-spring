package com.amudiel.amudiel_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("models")
public class AmudielSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmudielSpringApplication.class, args);
	}

}
