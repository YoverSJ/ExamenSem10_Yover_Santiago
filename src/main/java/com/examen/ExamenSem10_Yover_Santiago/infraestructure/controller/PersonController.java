package com.examen.ExamenSem10_Yover_Santiago.infraestructure.controller;

import com.examen.ExamenSem10_Yover_Santiago.application.service.PersonService;
import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> obtenerPersonas(){
        return new ResponseEntity<>(personService.obtenerPersonas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> crearPersona(@RequestBody Person person){
        return new ResponseEntity<>(personService.crearPersona(person), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> obtenerPersonaPorId(@PathVariable Long id){
        return personService.obtenerPersonaPorId(id).map(person -> new ResponseEntity<>(person, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> actualizarPersonaPorId(@PathVariable Long id, @RequestBody Person person){
        return personService.actualizarPersona(id, person).map(person1 -> new ResponseEntity<>(person1, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersonaPorId(@PathVariable Long id){

        if (personService.eliminarPersonaPorId(id)){
            return new ResponseEntity<>("{ \"message\": " + "\"Registro eliminado\"}", HttpStatus.OK);
        }

        return new ResponseEntity<>("{ \"message\": " + "\"Registro no eliminado\"}", HttpStatus.NOT_FOUND);

    }

}
