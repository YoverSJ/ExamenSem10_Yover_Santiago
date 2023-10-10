package com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.UserRepositoryPort;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserJpaRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserJpaRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> getUsers() {
        //return userJpaRepository.findByEstado(1);
        List<UserEntity> userEntities = userJpaRepository.findAll();

        List<User> users = new ArrayList<>();

        userEntities.forEach(user -> {
            users.add(user.toDomainModel());
        });

        return users;
    }

    @Override
    public User save(User user) {
        System.out.println("REEEEEEER");
        System.out.println(user.toString());
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        UserEntity saveUserEntity = userJpaRepository.save(userEntity);
        return saveUserEntity.toDomainModel();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id).map(UserEntity::toDomainModel);
    }

    @Override
    public Optional<User> update(Long id, User user) {

        Optional<User> userExistente = findById(id);

        if (userExistente.isPresent()){
            UserEntity userEntity = UserEntity.fromDomainModel(user);
            UserEntity updateUserEntity = userJpaRepository.save(userEntity);
            return Optional.of(updateUserEntity.toDomainModel());
        }

        return Optional.empty();

    }

    @Override
    public Boolean deleteById(Long id) {

        Optional<User> userExistente = findById(id);

        if (userExistente.isPresent()){

            UserEntity userEntity = UserEntity.fromDomainModel(userExistente.get());

            if (userEntity.getEstado() == 1){
                userEntity.setEstado(0);
                userJpaRepository.save(userEntity);
                return true;
            }

        }

        return false;

    }
}
