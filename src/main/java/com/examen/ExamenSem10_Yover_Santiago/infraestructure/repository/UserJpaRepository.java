package com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    List<User> findByEstado(int estado);

}
