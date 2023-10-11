package com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository;

import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.domain.ports.out.UserRepositoryPort;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.UserEntity;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.security.CustomerDetailsService;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserJpaRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public UserJpaRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> getUsers() {
        return userJpaRepository.findByEstado(1);
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

    @Override
    public ResponseEntity<String> loginWithUser(Map<String, String> requestMap) {

        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestMap.get("usuario"),requestMap.get("password")));

            if(authentication.isAuthenticated()){
                if(customerDetailsService.getUserDetail().getEstado() == 1 ){
                    return new ResponseEntity<String>(
                            "{\"token \":\"" + jwtUtil.generateToken(customerDetailsService.getUserDetail().getUsuario(),
                                    customerDetailsService.getUserDetail().getRole()) +"\"}",
                            HttpStatus.OK);
                }
            }else{
                return new ResponseEntity<String>("{\"mensaje\": " + "Espera la Aprobación del administrador"+"\"}",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>("{\"mensaje\": " + "Credenciales Incorrectas"+"\"}",HttpStatus.BAD_REQUEST);

    }
}
