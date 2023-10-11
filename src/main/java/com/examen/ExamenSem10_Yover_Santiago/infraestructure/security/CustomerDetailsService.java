package com.examen.ExamenSem10_Yover_Santiago.infraestructure.security;

//import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.entity.UserEntity;
import com.examen.ExamenSem10_Yover_Santiago.infraestructure.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    private UserEntity userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = userJpaRepository.findByUsuario(username);
        if(!Objects.isNull(userDetail)){
            return new User(userDetail.getUsuario(),userDetail.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
    }

    public UserEntity getUserDetail(){
        return userDetail;
    }
}
