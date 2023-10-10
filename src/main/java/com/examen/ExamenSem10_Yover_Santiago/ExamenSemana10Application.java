package com.examen.ExamenSem10_Yover_Santiago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExamenSemana10Application {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSemana10Application.class, args);
	}

}
