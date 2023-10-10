package com.examen.ExamenSem10_Yover_Santiago.application.service;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.in.PersonUseCase;

import java.util.List;
import java.util.Optional;

public class PersonService implements PersonUseCase {

    private final PersonUseCase personUseCase;

    public PersonService(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @Override
    public List<Person> obtenerPersonas() {
        return personUseCase.obtenerPersonas();
    }

    @Override
    public Person crearPersona(Person person) {
        return personUseCase.crearPersona(person);
    }

    @Override
    public Optional<Person> obtenerPersonaPorId(Long id) {
        return personUseCase.obtenerPersonaPorId(id);
    }

    @Override
    public Optional<Person> actualizarPersona(Long id, Person person) {
        return personUseCase.actualizarPersona(id, person);
    }

    @Override
    public Boolean eliminarPersonaPorId(Long id) {
        return personUseCase.eliminarPersonaPorId(id);
    }
}
