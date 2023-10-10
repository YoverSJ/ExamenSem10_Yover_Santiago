package com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.PersonRepositoryPort;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonJpaRepositoryAdapter implements PersonRepositoryPort {

    private final PersonJpaRepository personJpaRepository;

    public PersonJpaRepositoryAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public List<Person> getPersons() {
        return personJpaRepository.findByEstado(1);
    }

    @Override
    public Person save(Person person) {
        System.out.println(person.getApellidos());
        PersonEntity personEntity = PersonEntity.fromDomainModel(person);
        PersonEntity savePersonEntity = personJpaRepository.save(personEntity);
        return savePersonEntity.toDomainModel();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personJpaRepository.findById(id).map(PersonEntity::toDomainModel);
    }

    @Override
    public Optional<Person> update(Long id, Person person) {

        Optional<Person> personExistente = findById(id);

        if (personExistente.isPresent()){

            PersonEntity personEntity = PersonEntity.fromDomainModel(person);
            PersonEntity updatePersonEntity = personJpaRepository.save(personEntity);
            return Optional.of(updatePersonEntity.toDomainModel());

        }else {
            return Optional.empty();
        }

    }

    @Override
    public Boolean deleteById(Long id) {

        Optional<Person> personExistente = findById(id);

        if (personExistente.isPresent()){

            PersonEntity personEntity = PersonEntity.fromDomainModel(personExistente.get());

            if (personEntity.getEstado() == 1){
                personEntity.setEstado(0);
                personJpaRepository.save(personEntity);
                return true;
            }

        }

        return false;
    }
}
