package com.example.galaxy.aircraft;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.galaxy.aircraft.domain", considerNestedRepositories = true)
public class AirCraftConfig {
}
