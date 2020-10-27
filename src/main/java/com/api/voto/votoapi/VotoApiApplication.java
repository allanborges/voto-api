package com.api.voto.votoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@ComponentScan({"com.api.voto.service","com.api.voto","com.api.voto.controllers"})
@EnableReactiveMongoRepositories({"com.api.voto"})
@SpringBootApplication
public class VotoApiApplication {

	public static void main(String[] args) {		
		SpringApplication.run(VotoApiApplication.class, args);		
	}

}
