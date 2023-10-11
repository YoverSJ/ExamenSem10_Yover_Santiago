package com.examen.ExamenSem10_Yover_Santiago.domain.ports.out;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepositoryPort {

    List<User> getUsers();
    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> update(Long id, User user);

    Boolean deleteById(Long id);

    ResponseEntity<String> loginWithUser(Map<String, String> requestMap);

}
