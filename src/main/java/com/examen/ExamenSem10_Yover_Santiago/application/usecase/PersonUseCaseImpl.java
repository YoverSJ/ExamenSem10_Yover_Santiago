package com.examen.ExamenSem10_Yover_Santiago.application.usecase;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.in.PersonUseCase;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.PersonRepositoryPort;

import java.util.List;
import java.util.Optional;

public class PersonUseCaseImpl implements PersonUseCase {

    private final PersonRepositoryPort personRepositoryPort;

    public PersonUseCaseImpl(PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public List<Person> obtenerPersonas() {
        return personRepositoryPort.getPersons();
    }

    @Override
    public Person crearPersona(Person person) {
        return personRepositoryPort.save(person);
    }

    @Override
    public Optional<Person> obtenerPersonaPorId(Long id) {
        return personRepositoryPort.findById(id);
    }

    @Override
    public Optional<Person> actualizarPersona(Long id, Person person) {
        return personRepositoryPort.update(id, person);
    }

    @Override
    public Boolean eliminarPersonaPorId(Long id) {
        return personRepositoryPort.deleteById(id);
    }
}
