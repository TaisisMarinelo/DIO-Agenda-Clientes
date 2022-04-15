package com.digitalinnovation.agendaclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot
 * 
 * @author TaisisMarinelo
 *
 */

@EnableFeignClients
@SpringBootApplication
public class AgendaClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaClientesApplication.class, args);
	}

}
