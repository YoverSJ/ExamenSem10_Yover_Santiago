package com.examen.ExamenSem10_Yover_Santiago.application.service;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.in.UserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements UserUseCase {

    private final UserUseCase userUseCase;

    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public List<User> obtenerUsuarios() {
        return userUseCase.obtenerUsuarios();
    }

    @Override
    public User crearUsuario(User user) {
        return userUseCase.crearUsuario(user);
    }

    @Override
    public Optional<User> obtenerUsuarioPorId(Long id) {
        return userUseCase.obtenerUsuarioPorId(id);
    }

    @Override
    public Optional<User> actualizarUsuario(Long id, User user) {
        return userUseCase.actualizarUsuario(id, user);
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        return userUseCase.eliminarUsuarioPorId(id);
    }
}
