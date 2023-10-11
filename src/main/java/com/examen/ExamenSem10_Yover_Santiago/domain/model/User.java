package com.examen.ExamenSem10_Yover_Santiago.domain.model;

import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Long id;
    private String usuario;
    private String password;
    private Integer estado;
    private String role;
    private PersonEntity person;
    private Date fechaCrea;
    private Date fechaMod;

    public User(Long id, String usuario, String password, Integer estado, String role, PersonEntity person, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.role = role;
        this.person = person;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                ", role='" + role + '\'' +
                ", person=" + person +
                ", fechaCrea=" + fechaCrea +
                ", fechaMod=" + fechaMod +
                '}';
    }
}
