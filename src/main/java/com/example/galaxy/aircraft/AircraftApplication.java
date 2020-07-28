package com.example.galaxy.aircraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AirCraftConfig.class)
public class AircraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(AircraftApplication.class, args);
	}

}
