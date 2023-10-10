package com.examen.ExamenSem10_Yover_Santiago.application.usecase;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.in.UserUseCase;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class UserUseCaseImpl implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> obtenerUsuarios() {
        return userRepositoryPort.getUsers();
    }

    @Override
    public User crearUsuario(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> obtenerUsuarioPorId(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public Optional<User> actualizarUsuario(Long id, User user) {
        return userRepositoryPort.update(id, user);
    }

    @Override
    public Boolean eliminarUsuarioPorId(Long id) {
        return userRepositoryPort.deleteById(id);
    }
}
