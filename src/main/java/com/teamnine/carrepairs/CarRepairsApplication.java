package com.teamnine.carrepairs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.teamnine.carrepairs.*")
public class CarRepairsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRepairsApplication.class, args);


	}
}
