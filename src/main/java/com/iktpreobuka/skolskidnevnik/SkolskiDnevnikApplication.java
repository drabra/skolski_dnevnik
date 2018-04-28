package com.iktpreobuka.skolskidnevnik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan ({"com.server", "com.server.config"})
@EnableJpaRepositories
@EnableConfigurationProperties
public class SkolskiDnevnikApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SkolskiDnevnikApplication.class, args);
		
	}
}
