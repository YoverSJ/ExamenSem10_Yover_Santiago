package com.examen.ExamenSem10_Yover_Santiago.domain.ports.out;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryPort {

    List<Person> getPersons();
    Person save(Person person);

    Optional<Person> findById(Long id);

    Optional<Person> update(Long id, Person person);

    Boolean deleteById(Long id);

}
