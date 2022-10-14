package com.Reto3.AlquilerBarcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"com.Reto3.AlquilerBarcos"})
@SpringBootApplication
public class AlquilerBarcosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquilerBarcosApplication.class, args);
	}

}
