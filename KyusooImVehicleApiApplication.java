package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class KyusooImVehicleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyusooImVehicleApiApplication.class, args);
	}
}
