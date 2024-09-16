package com.hajer.DataDoor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DataDoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataDoorApplication.class, args);
	}

}
