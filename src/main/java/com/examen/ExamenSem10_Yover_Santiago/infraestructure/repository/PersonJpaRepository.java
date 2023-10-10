package com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {

    List<Person> findByEstado(int estado);

}
