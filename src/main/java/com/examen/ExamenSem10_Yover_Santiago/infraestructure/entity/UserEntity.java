package com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;

    @Column(columnDefinition = "INT DEFAULT 1")
    private Integer estado;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @CreatedDate
    @Column(name = "fecha_crea", nullable = false, updatable = false)
    private Date fechaCrea;

    @LastModifiedDate
    @Column(name = "fecha_mod")
    private Date fechaMod;

    public UserEntity() {
    }

    public UserEntity(Long id, String usuario, String password, Integer estado, PersonEntity person, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.person = person;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }

    public static UserEntity fromDomainModel(User user){
        return new UserEntity(user.getId(), user.getUsuario(), user.getPassword(), user.getEstado(), PersonEntity.fromDomainModel(user.getPerson()), user.getFechaCrea(), user.getFechaMod());
    }

    public User toDomainModel(){
        return new User(id, usuario, password, estado, person.toDomainModel(), fechaCrea, fechaMod);
    }
}
