package com.examen.ExamenSem10_Yover_Santiago.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Person {

    private Long id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;
    private Date fechaCrea;
    private Date fechaMod;

    public Person(Long id, String nombres, String apellidos, String direccion, String email, String telefono, Integer estado, Date fechaCrea, Date fechaMod) {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado=" + estado +
                ", fechaCrea=" + fechaCrea +
                ", fechaMod=" + fechaMod +
                '}';
    }
}
