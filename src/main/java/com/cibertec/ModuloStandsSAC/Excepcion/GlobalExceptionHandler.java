package com.cibertec.ModuloStandsSAC.Excepcion;

import com.cibertec.ModuloStandsSAC.DTO.Excepcion.ExepcionMessage;
import com.cibertec.ModuloStandsSAC.DTO.Mobiliario.MobiliarioMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MobiliarioInactivoException.class)
    public ResponseEntity<MobiliarioMessage> handleMobiliario(MobiliarioInactivoException ex){
        MobiliarioMessage message =new MobiliarioMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProyectoInactivoExcepcion.class)
    public ResponseEntity<ExepcionMessage> handleProyecto(ProyectoInactivoExcepcion ex){
        ExepcionMessage message =new ExepcionMessage(ex.getMessage(),HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExepcionMessage> handleNotFound (EntityNotFoundException ex){
        int cod = HttpStatus.NOT_FOUND.value();
        ExepcionMessage message = new ExepcionMessage(ex.getMessage(),cod);
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExepcionMessage> handleIlegal(IllegalArgumentException ex){
        int cod = HttpStatus.BAD_REQUEST.value();
        ExepcionMessage message = new ExepcionMessage(ex.getMessage(),cod);
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
