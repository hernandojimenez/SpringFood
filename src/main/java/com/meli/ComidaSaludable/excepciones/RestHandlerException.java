package com.meli.ComidaSaludable.excepciones;

import com.meli.ComidaSaludable.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestHandlerException {

    @ExceptionHandler(CaloriasExcepciones.class)
    public ResponseEntity caloriasExcepcion(CaloriasExcepciones e ){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(),e.getCode(),HttpStatus.NOT_FOUND);
        return new ResponseEntity(errorDTO,HttpStatus.NOT_FOUND);
    }
}
