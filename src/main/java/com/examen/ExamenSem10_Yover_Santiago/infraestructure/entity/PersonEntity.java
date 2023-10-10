package com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.Person;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;

    @Column(columnDefinition = "INT DEFAULT 1")
    private Integer estado;

    @CreatedDate
    @Column(name = "fecha_crea", nullable = false, updatable = false)
    private Date fechaCrea;

    @LastModifiedDate
    @Column(name = "fecha_mod")
    private Date fechaMod;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String nombres, String apellidos, String direccion, String email, String telefono, Integer estado, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }

    public static PersonEntity fromDomainModel(Person person){
        return new PersonEntity(person.getId(), person.getNombres(), person.getApellidos(), person.getDireccion(), person.getEmail(), person.getTelefono(), person.getEstado(), person.getFechaCrea(), person.getFechaMod());
    }

    public Person toDomainModel(){
        return new Person(id, nombres, apellidos, direccion, email, telefono, estado, fechaCrea, fechaMod);
    }
}
