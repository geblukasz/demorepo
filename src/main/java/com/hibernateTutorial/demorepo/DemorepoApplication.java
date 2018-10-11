package com.hibernateTutorial.demorepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@EntityScan(
		basePackageClasses = {DemorepoApplication.class, Jsr310Converters.class}
)
@SpringBootApplication
public class DemorepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorepoApplication.class, args);
	}
}
