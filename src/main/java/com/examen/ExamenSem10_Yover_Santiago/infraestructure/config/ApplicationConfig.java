package com.examen.ExamenSem10_Yover_Santiago.infraestructure.config;

import com.examen.ExamenSem10_Yover_Santiago.application.service.PersonService;
import com.examen.ExamenSem10_Yover_Santiago.application.service.UserService;
import com.examen.ExamenSem10_Yover_Santiago.application.usecase.PersonUseCaseImpl;
import com.examen.ExamenSem10_Yover_Santiago.application.usecase.UserUseCaseImpl;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.PersonRepositoryPort;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.UserRepositoryPort;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository.PersonJpaRepositoryAdapter;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository.UserJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PersonService personService(PersonRepositoryPort personRepositoryPort){
        return new PersonService(new PersonUseCaseImpl(personRepositoryPort));
    }

    @Bean
    public PersonRepositoryPort personRepositoryPort(PersonJpaRepositoryAdapter personJpaRepositoryAdapter){
        return personJpaRepositoryAdapter;
    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(new UserUseCaseImpl(userRepositoryPort));
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(UserJpaRepositoryAdapter userJpaRepositoryAdapter){
        return userJpaRepositoryAdapter;
    }

}
