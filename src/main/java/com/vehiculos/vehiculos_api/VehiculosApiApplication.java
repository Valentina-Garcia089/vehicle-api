package com.vehiculos.vehiculos_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication
public class VehiculosApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehiculosApiApplication.class, args);
	}
}
