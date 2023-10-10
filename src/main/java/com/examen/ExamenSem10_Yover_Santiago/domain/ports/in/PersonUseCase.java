package com.examen.ExamenSem10_Yover_Santiago.domain.ports.in;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonUseCase {

    List<Person> obtenerPersonas();
    Person crearPersona(Person person);

    Optional<Person> obtenerPersonaPorId(Long id);

    Optional<Person> actualizarPersona(Long id, Person person);

    Boolean eliminarPersonaPorId(Long id);

}
