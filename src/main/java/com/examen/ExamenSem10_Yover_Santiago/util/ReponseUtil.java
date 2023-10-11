package com.examen.ExamenSem10_Yover_Santiago.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ReponseUtil {

    public ReponseUtil() {
    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<>("Mensaje: " + message, httpStatus);
    }
}
