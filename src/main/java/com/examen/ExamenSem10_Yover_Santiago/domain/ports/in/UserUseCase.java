package com.examen.ExamenSem10_Yover_Santiago.domain.ports.in;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserUseCase {

    List<User> obtenerUsuarios();

    User crearUsuario(User user);

    Optional<User> obtenerUsuarioPorId(Long id);

    Optional<User> actualizarUsuario(Long id, User user);

    Boolean eliminarUsuarioPorId(Long id);

}
