package com.examen.ExamenSem10_Yover_Santiago.infraestructure.controller;

import com.examen.ExamenSem10_Yover_Santiago.application.service.UserService;
import com.examen.ExamenSem10_Yover_Santiago.constants.Constants;
import com.examen.ExamenSem10_Yover_Santiago.domain.model.User;
import com.examen.ExamenSem10_Yover_Santiago.util.ReponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginWithUser(@RequestBody(required = true) Map<String, String> requestMap){
        try {
            return userService.iniciarSesionConUsuario(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ReponseUtil.getResponseEntity(Constants.ALGO_SALIO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<User>> obtenerUsuarios(){
        return new ResponseEntity<>(userService.obtenerUsuarios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> crearPersona(@RequestBody User user){
        System.out.println(user.toString());
        return new ResponseEntity<>(userService.crearUsuario(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUsuarioPorId(@PathVariable Long id){
        return userService.obtenerUsuarioPorId(id).map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarUsuarioPorId(@PathVariable Long id, @RequestBody User user){
        return userService.actualizarUsuario(id, user).map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable Long id){

        if (userService.eliminarUsuarioPorId(id)){
            return new ResponseEntity<>("{ \"message\": " + "\"Registro eliminado\"}", HttpStatus.OK);
        }

        return new ResponseEntity<>("{ \"message\": " + "\"Registro no eliminado\"}", HttpStatus.NOT_FOUND);

    }
}
